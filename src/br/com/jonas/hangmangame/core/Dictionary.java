package br.com.jonas.hangmangame.core;

public abstract class Dictionary {
		
	private static Dictionary instance;
	
	public static Dictionary getInstance() {
		if (instance == null) {
			instance = new StaticDictionary();
		}
		return instance;
	}
	
	public abstract Word nextWord();
	
	public abstract String getName();
}
