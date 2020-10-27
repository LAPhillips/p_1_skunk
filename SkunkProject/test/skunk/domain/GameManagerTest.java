package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameManagerTest {

	@Test
	void game_creator_makes_players() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		assertNotNull(manager.getPlayer());
	}
	
	
	@Test
	void game_creator_lets_player_roll_dice() {
		GameManager manager = new GameManager();
		int result = manager.playerRollsDice();
		assertEquals(3, result);
	}
	

}
