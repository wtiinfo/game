package com.iwsistemas.escadaseserpentes.counter;

import com.iwsistemas.escadaseserpentes.board.Board;
import com.iwsistemas.escadaseserpentes.board.Space;
import com.iwsistemas.escadaseserpentes.core.Dice;

public class Counter {

	private String name;
	private Space currentSpace;
	
	public Counter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Space getCurrentSpace() {
		return currentSpace;
	}

	public void goTo(Space space) {
		currentSpace = space;
	}
	
	public void play(Board board) {
		Dice dice = Dice.get();// Singleton
		int diceNumber = dice.roll();
		
		System.out.format("Jogador %s, jogou o dado e o resultado foi: %d%n", name, diceNumber);
		
		board.move(this, diceNumber);
	}
	
}
