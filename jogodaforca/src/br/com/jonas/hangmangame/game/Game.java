package br.com.jonas.hangmangame.game;

import br.com.jonas.hangmangame.core.Dictionary;
import br.com.jonas.hangmangame.core.Word;

public class Game {

	public void start() {
		
		Dictionary dictionary1 = Dictionary.getInstance();
		Dictionary dictionary2 = Dictionary.getInstance();
		System.out.println(dictionary1);
		System.out.println(dictionary2);
		
		Word w1 = dictionary1.nextWord();
		System.out.println(w1.getOriginalWord());
	}
}