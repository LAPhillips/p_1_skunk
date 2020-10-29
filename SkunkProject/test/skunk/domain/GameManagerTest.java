package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		int[] result = manager.playerRollsDice();
		int sumOfDice = result[0] + result[1];
		assertTrue( sumOfDice > 2 && sumOfDice < 13);
	}
	
	@Test
	void game_manager_lets_player_roll_fixed_dice() {
		GameManager manager = new GameManager();
		int[] result = manager.playerRollsDice(3,4);
		assertTrue(result[0] == 3 && result[1] == 4);
	}
	
	@Test
	void game_manager_shares_turn_scores() {
		GameManager manager = new GameManager();
		ArrayList<Integer> turnScores = manager.sharesTurnScores();
		assertNotNull(turnScores);
	}
	
/*
	@Test
	void game_manager_records_TurnScore() {
		GameManager manager = new GameManager();
		int[] newScore = new int[] {3,4};
		manager.recordsTheTurnScore(newScore);
		assertTrue(result == 0);
	}

*/
}
