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
	
	
	@Test
	void game_manager_has_player_roll_dice() {
		GameManager manager = new GameManager();
		manager.playerRollsDice();
		int[] result = manager.returnDiceRoll();
		int sumOfDice = result[0] + result[1];
		assertTrue( sumOfDice > 2 && sumOfDice < 13);
	}
	

	@Test
	void game_manager_lets_player_roll_fixed_dice() {
		GameManager manager = new GameManager();
		manager.playerRollsDice(3,4);
		int[] result = manager.returnDiceRoll();
		assertTrue(result[0] == 3 && result[1] == 4);
	}
	
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
	void game_manager_shares_dice_total_score() {
		GameManager manager = new GameManager();
		manager.playerRollsDice(2, 5);
		int result = manager.diceTotalScore();
		int expected =7;
		assertEquals(expected, result);
	}
	
	@Test
	void game_manager_shares_turn_total_score() {
		GameManager manager = new GameManager();
		int die1 = 3;
		int die2 = 4;
		int die3 = 6;
		int die4 = 7;
		int expected = die1 + die2 + die3 + die4;
		manager.checkRollRecord(die1, die2);
		manager.checkRollRecord(die3, die4);
		int actual = manager.totalTurnScore();
		assertEquals(expected, actual);
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
	
	@Test
	void game_manager_sees_if_roll_again_before_rolling() {
		GameManager manager = new GameManager();
		int expected = 4; 
		manager.checkRollRecord(2, expected);
		int [] diceRoll = manager.returnDiceRoll();
		manager.setContinueTurn('N');
		manager.checkRollRecord();
		int actual = diceRoll[1];		
		assertEquals(expected, actual);
	}
	
	@Test
	void game_manager_records_after_successful_roll() {
		GameManager manager = new GameManager();
		manager.checkRollRecord(5,4);
		int [] newScore = manager.returnDiceRoll();
		ArrayList<Integer> actualTurnScores = manager.sharesTurnScores();
		assertTrue(newScore[0]== actualTurnScores.get(0) && newScore[1] == actualTurnScores.get(1));
	}
	
	@Test
	void game_manager_gets_number_of_rolls() {
		GameManager manager = new GameManager();
		for (int i = 0; i < 10; i++) {
			manager.checkRollRecord(2, 3);
		}
		int numberOfRolls = manager.numberOfRolls();
		assertEquals(10, numberOfRolls);	
	}
	
	/*
	To be worked on
	@Test
	void game_manager_ends_Turn() {
		GameManager manager = new GameManager();
		manager.setContinueTurn('N');
		Boolean playerInput = manager.getContinueTurn();
		manager.endsTurn();
		assertTrue(playerInput);
	} */
	
}
