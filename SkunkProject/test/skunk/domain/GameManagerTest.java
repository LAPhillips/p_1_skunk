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
	void game_manager_returns_dice_array() {
		GameManager manager = new GameManager();
		int expected1 = 2;
		int expected2 = 3;
		manager.playerRollsDice(expected1, expected2);
		int[] diceArray = manager.returnDiceRoll();
		int die1 = diceArray[0];
		int die2 = diceArray[1];
		assertTrue(expected1 == die1 && expected2 == die2);
	}
	
	/*
	@Test
	void game_manager_has_player_roll_dice() {
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
	}*/
	
	@Test
	void game_manager_shares_turn_scores() {
		GameManager manager = new GameManager();
		ArrayList<Integer> turnScores = manager.sharesTurnScores();
		int[] newScore = new int[] {3,6};
		manager.recordsTheTurnScore(newScore);
		assertEquals(newScore[1], turnScores.get(1));
	}
	

	@Test
	void game_manager_records_TurnScore() {
		GameManager manager = new GameManager();
		int[] newScore = new int[] {3,4};
		manager.recordsTheTurnScore(newScore);
		int[] anotherRoll = new int[] {5,2};
		manager.recordsTheTurnScore(anotherRoll);
		ArrayList <Integer> scoreboard = manager.sharesTurnScores();
		assertTrue(scoreboard.size() == 4);
	}
	
	@Test
	void game_manager_shares_total_score() {
		GameManager manager = new GameManager();
		manager.playerRollsDice(2, 5);
		int result = manager.diceTotalScore();
		int expected =7;
		assertEquals(expected, result);
	}
	
	@Test
	void game_manager_reads_player_decision() {
		GameManager manager = new GameManager();
		Boolean playerInput = manager.getContinueTurn();
		assertTrue(playerInput);
	}
	
	@Test
	void game_manager_sets_player_decision() {
		GameManager manager = new GameManager();
		char playerDecision = 'N';
		Boolean expected = false;
		manager.setContinueTurn(playerDecision);
		Boolean actual = manager.getContinueTurn();
		assertEquals(expected, actual);
	}


}
