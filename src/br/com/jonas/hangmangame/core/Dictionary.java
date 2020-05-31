package br.com.jonas.hangmangame.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Dictionary {
		
	private static Dictionary instance;
	
	public static Dictionary getInstance() {
		if (instance == null) {
			try {
				String dictionaryClassName = Config.get("dictionaryClassName");
				Class<?> clazz = Class.forName(dictionaryClassName);
				Constructor<?> constructor = clazz.getConstructor();
				instance = (Dictionary) constructor.newInstance();
			
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException();
			}
		}
		return instance;
	}
	
	public abstract Word nextWord();
	
	public abstract String getName();
}
