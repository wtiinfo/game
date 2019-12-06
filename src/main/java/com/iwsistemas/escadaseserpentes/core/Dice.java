package com.iwsistemas.escadaseserpentes.core;

import java.util.Random;

public class Dice {
    private static final int MAX_NUMBER = 6;// Opcional
	private static Dice instace;
	private Random random = new Random();
	
	private Dice() {
	}

	public static Dice get() {
		if (instace == null) {
			instace = new Dice();
		}
		return instace;
	}
	
	public int roll() {
		return random.nextInt(MAX_NUMBER) + 1;
	}
}
