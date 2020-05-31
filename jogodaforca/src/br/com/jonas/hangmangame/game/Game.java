package br.com.jonas.hangmangame.game;

import java.util.HashSet;
import java.util.Set;

import br.com.jonas.hangmangame.core.Dictionary;
import br.com.jonas.hangmangame.core.Word;
import br.com.jonas.hangmangame.exceptions.InvalidCharacterException;
import br.com.jonas.hangmangame.ui.UI;

public class Game {
	
	private static final int MAX_ERRORS = 5;

	public void start() {
		UI.print("Welcome to the Hangman Game!");
		
		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();
		
		UI.print("The word has " + word.size() + " letters");
		
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
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
					
					if (errorCount < MAX_ERRORS) {
						UI.print("You missed! You can still get it wrong " + (MAX_ERRORS - errorCount) + " time(s)");
					}
				}
				
				UI.printNewLine();
				
				if (word.discovered()) {
					UI.print("CONGRATULATIONS! You got the word right: " + word.getOriginalWord());
					UI.print("End of the game!");
					break;
				}
				
				if (errorCount == MAX_ERRORS) {
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