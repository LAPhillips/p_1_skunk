package myskunk.pl;

import skunk.domain.GamePlay;

public class SkunkApp {

	public static void main(String[] args) {
		GamePlay play = new GamePlay();
		
		play.howManyPlayers();
		play.allPlayersOneTurn();
	}

}
