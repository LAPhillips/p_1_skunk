package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GamePlayTest {

	
	@Test
	void GP_gets_next_player() {
		GamePlay play = new GamePlay();
		Player player1 = new Player ("player1");
		Player player2 = new Player ("player2");
		Player[] players = new Player[] {player1, player2};
		
		play.setPlayers(players);
		play.setActivePlayer(player1);
		play.setPlayerTracker(1);
		play.nextPlayer();
		
		assertEquals(player2, play.getActivePlayer());		
	}

}
