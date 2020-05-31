package br.com.jonas.hangmangame.ui;

import java.util.Scanner;

import br.com.jonas.hangmangame.exceptions.InvalidCharacterException;

public class UI {

	public static void print(Object object) {
		System.out.println(object);
	}
	
	public static void printNewLine() {
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException {
		System.out.println(text + " ");
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		if (line.trim().isEmpty()) {
			throw new InvalidCharacterException("No letters were entered");
		}
		
		if (line.length() > 1) {
			throw new InvalidCharacterException("Only one letter must be entered");
		}
		
		char c = line.charAt(0);
		
		if (!Character.isLetter(c)) {
			throw new InvalidCharacterException("Only letters must be entered");
		}
		
		return c;
	}
}
