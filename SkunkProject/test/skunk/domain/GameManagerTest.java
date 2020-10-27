package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameManagerTest {

	@Test
	void game_creator_makes_players() {
		GameManager creator = new GameManager();
		creator.createPlayer("player1");
		assertNotNull(creator.getPlayer());
	}
	
	/*
	@Test
	void game_creator_lets_player_roll_dice() {
		GameManager manager = new GameManager();
		manager.playerRollsDice();
		int result = 0;
		assertTrue( result == 3);
	}
	*/

}
