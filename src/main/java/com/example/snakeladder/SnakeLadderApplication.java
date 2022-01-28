package com.example.snakeladder;

import com.example.snakeladder.entities.Player;

public class SnakeLadderApplication {

	public static void main(String[] args) {
		Game game = new Game(10, 1);
		game.addPlayer(new Player("A"));
		game.addPlayer(new Player("B"));
		game.addPlayer(new Player("C"));
		game.launch();
	}

}
