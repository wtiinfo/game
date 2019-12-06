package com.iwsistemas.escadaseserpentes;

import com.iwsistemas.escadaseserpentes.core.Game;

public class Application {

	public static void main(String[] args) {
		try {
			Game game = new Game();
			game.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
