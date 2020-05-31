package br.com.jonas.hangmangame.game;

import br.com.jonas.hangmangame.core.Word;

public class Game {

	public void start() {
		
		Word word = new Word("casa");
		word.hasChar('a');
		word.hasChar('c');
		word.hasChar('s');
		System.out.println(word.discovered());
		
		System.out.println(word);
	}
}