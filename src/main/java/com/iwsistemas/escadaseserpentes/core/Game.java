package com.iwsistemas.escadaseserpentes.core;

import com.iwsistemas.escadaseserpentes.board.Board;
import com.iwsistemas.escadaseserpentes.counter.Counter;
import com.iwsistemas.escadaseserpentes.counter.Counters;

public class Game {

	private static final int NUM_SPACES = 30;
	private static final int NUM_PLAYERS = 2;
	
	/**
	 * Metodo responsavel por instanciar o tabuleiro e iniciar o jogo
	 * @author Wando Borges
	 * 
	 */
	public void play() {
		Board board = new Board(NUM_SPACES);
		
		addTransitions(board);
		
		board.print();
		
		Counters counters = new Counters(board, NUM_PLAYERS);
		counters.print();
		
		while(!board.gameFinished()) {
			Counter currentCounter = counters.next();
			currentCounter.play(board);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Counter winnerCounter = board.getWinnerCounter();
		System.out.format("Jogador %s GANHOU!%n", winnerCounter.getName());
	}

	private void addTransitions(Board board) {
		board.addTransition(4, 12); // ESCADA
		board.addTransition(7, 9); // ESCADA
		board.addTransition(11, 25); // ESCADA
		board.addTransition(14, 2); // SERPENTE
		board.addTransition(22, 5); // SERPENTE
		board.addTransition(28, 18); // SERPENTE
	}
	
}
