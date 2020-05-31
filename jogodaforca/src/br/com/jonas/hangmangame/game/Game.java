package br.com.jonas.hangmangame.game;

import java.util.HashSet;
import java.util.Set;

import br.com.jonas.hangmangame.core.Config;
import br.com.jonas.hangmangame.core.Dictionary;
import br.com.jonas.hangmangame.core.Word;
import br.com.jonas.hangmangame.exceptions.InvalidCharacterException;
import br.com.jonas.hangmangame.ui.UI;

public class Game {

	public void start() {
		UI.print("Welcome to the Hangman Game!");
		
		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();
		
		UI.print("The word has " + word.size() + " letters");
		
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("You can make mistakes at most " + maxErrors + " time(s)");
		
		while (true) {
			UI.print(word);
			UI.printNewLine();
			
			char c;
			try {
				c = UI.readChar("Type a letter: ");
				
				if (usedChars.contains(c)) {
					throw new InvalidCharacterException("This letter has already been used");
				}
				
				usedChars.add(c);
				
				if (word.hasChar(c)) {
					UI.print("You hit a letter!");
					
				} else {
					errorCount++;
					
					if (errorCount < maxErrors) {
						UI.print("You missed! You can still get it wrong " + (maxErrors - errorCount) + " time(s)");
					}
				}
				
				UI.printNewLine();
				
				if (word.discovered()) {
					UI.print("CONGRATULATIONS! You got the word right: " + word.getOriginalWord());
					UI.print("End of the game!");
					break;
				}
				
				if (errorCount == maxErrors) {
					UI.print("You lost the game! The correct word was: " + word.getOriginalWord());
					UI.print("End of the game!");
					break;
				}
				
			} catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}
	}
}