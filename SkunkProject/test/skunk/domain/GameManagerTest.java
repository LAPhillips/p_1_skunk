package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameManagerTest {

	@Test
	void game_manager_makes_players() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		assertNotNull(manager.getPlayer());
	}
	
	@Test
	void game_manager_lets_player_roll_dice() {
		GameManager manager = new GameManager();
		int result = manager.playerRollsDice();
		assertTrue( result > 2 && result < 13);
	}
	
	@Test
	void game_manager_lets_player_roll_fixed_dice() {
		GameManager manager = new GameManager();
		int result = manager.playerRollsFixedDice();
		assertTrue( result == 5);
	}
	
	
	
	/*
	@Test
	void game_manager_records_TurnScore() {
		GameManager manager = new GameManager();
		manager.recordsTheTurnScore();
		int result = 0;
		assertTrue(result == 0);
	}
	*/

}
