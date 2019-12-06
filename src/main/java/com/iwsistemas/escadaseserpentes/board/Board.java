package com.iwsistemas.escadaseserpentes.board;

import java.util.Arrays;

import com.iwsistemas.escadaseserpentes.board.Space.Type;
import com.iwsistemas.escadaseserpentes.counter.Counter;
import com.iwsistemas.escadaseserpentes.infrastructure.Printable;

public class Board implements Printable {

	private Space[] spaces;
	private Space spaceHome;
	private Space spaceStartHere;
	
	private Counter winnerCounter;

	public Board(int numSpaces) {
		spaces = new Space[numSpaces + 2];
		for (int i = 0; i < spaces.length; i++) {
			if (i == 0) {
				spaces[i] = new Space(i, Type.START_HERE);
				spaceStartHere = spaces[i];
			} else if (i == spaces.length - 1) {
				spaces[i] = new Space(i, Type.HOME);
				spaceHome = spaces[i];
			} else {
				spaces[i] = new Space(i, Type.REGULAR);
			}
		}
	}

	@Override
	public String toString() {
		return "Board [spaces=" + Arrays.toString(spaces) + "]";
	}

	@Override
	public void print() {
		System.out.println("TABULEIRO: ");
		for (Space space : spaces) {
			System.out.print(space + " ");
		}
		System.out.println();
	}

	public void setupCounter(Counter[] counters) {
		for (Counter counter : counters) {
			counter.goTo(spaceStartHere);
		}
	}

	public Counter getWinnerCounter() {
		return winnerCounter;
	}
	
	public void move(Counter counter, int diceNumber) {
		Space space = counter.getCurrentSpace();
		int newSpaceNumber = space.getNumber() + diceNumber;
		Space newSpace;
		if(newSpaceNumber >= spaceHome.getNumber()) {
			newSpace = spaceHome;
			winnerCounter = counter;
		} else {
			newSpace = spaces[newSpaceNumber];
		}
		counter.goTo(newSpace);
		System.out.format("Jogador %s foi para casa %s%n", counter.getName(), newSpace);
	
		Trasition transition = newSpace.getTransition();
		
		if(transition != null) {
			System.out.format("Jogador %s encontrou uma %s na casa %s%n", counter.getName(), transition.getType(), newSpace);
			counter.goTo(transition.getSpaceTo()); // metodo correto SpaceTo
			System.out.format("Jogador %s foi para a casa %s%n", counter.getName(), transition.getSpaceTo()); 
		}
	
	}

	public boolean gameFinished() {
		return winnerCounter != null; // RETORNA TRUE, SE TIVER UM JOGADOR SETADO A VARIAVEL
	}
	
	public void addTransition(int from, int to) {
		Space spaceFrom  = spaces[from];
		Space spaceTo = spaces[to];
		
		Trasition transition = new Trasition(spaceFrom, spaceTo);
		spaceFrom.setTransition(transition);
	}
	
}
