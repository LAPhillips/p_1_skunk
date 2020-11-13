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
	void game_manager_shares_player_name() {
		GameManager manager = new GameManager();
		String expected = "player1";
		manager.createPlayer(expected);
		String result = manager.playerName();
		assertTrue(expected.equals(result));
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
		assertTrue( sumOfDice >= 2 && sumOfDice < 13);
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
		manager.createPlayer("player1");
		ArrayList<Integer> turnScores = manager.sharesTurnScores();
		int[] newScore = new int[] {3,6};
		manager.recordsTheTurnScore(newScore);
		assertEquals(newScore[1], turnScores.get(1));
	}

	@Test
	void game_manager_records_TurnScore() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
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
		manager.createPlayer("player1");
		int die1 = 3;
		int die2 = 4;
		int die3 = 6;
		int die4 = 7;
		int expected = die1 + die2 + die3 + die4;
		manager.checkRollRecord(die1, die2);
		manager.checkRollRecord(die3, die4);
		int actual = manager.getFinalTurnScore();
		assertEquals(expected, actual);
	}
	
	@Test
	void game_manager_reads_player_decision() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		Boolean playerInput = manager.getContinueTurn();
		assertTrue(playerInput);
	}
	
	@Test
	void game_manager_sets_player_decision() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		char playerDecision = 'N';
		Boolean expected = false;
		manager.setContinueTurn(playerDecision);
		Boolean actual = manager.getContinueTurn();
		assertEquals(expected, actual);
	}
	
	@Test
	void game_manager_sees_if_roll_again_before_rolling() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		int expected = 4; 
		manager.checkRollRecord(2, expected);
		int [] diceRoll = manager.returnDiceRoll();
		manager.setContinueTurn('N');
		manager.checkRollRecord();
		int actual = diceRoll[1];		
		assertEquals(expected, actual);
	}
	
	@Test
	void game_manager_records_after_roll() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		int [] newScore = manager.returnDiceRoll();
		manager.recordsTheTurnScore(newScore);
		ArrayList<Integer> actualTurnScores = manager.sharesTurnScores();
		assertTrue(newScore[0]== actualTurnScores.get(0) && newScore[1] == actualTurnScores.get(1));		
	}
	
	@Test
	void game_manager_records_both_special_and_normal_rolls() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.checkRollRecord(5,4);
		manager.checkRollRecord(1,4);
		ArrayList<Integer> actualTurnScores = manager.sharesTurnScores();
		assertEquals(4, actualTurnScores.size());
	}
	
	@Test
	void game_manager_gets_number_of_rolls() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		for (int i = 0; i < 10; i++) {
			manager.checkRollRecord(2, 3);
		}
		int numberOfRolls = manager.numberOfRolls();
		assertEquals(10, numberOfRolls);	
	}
	
	@Test
	void game_manager_can_see_turn_status() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		assertTrue(manager.getContinueTurn()); //default is true
	}
	
	@Test
	void game_manager_ends_Turn_if_Roll_is_Special() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.updatesForSpecialRolls();
		Boolean turn = manager.getContinueTurn();
		assertTrue(turn);
		
		manager.checkRollRecord(1,1);
		manager.updatesForSpecialRolls();
		turn = manager.getContinueTurn();
		assertFalse(turn);
	} 
	

	
	@Test
	void game_manager_flow_should_also_report_special() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.checkRollRecord(1,1);
		RollTypes rollType = manager.getRollType();
		RollTypes expected = RollTypes.DOUBLE_SKUNK;
		assertEquals(expected, rollType, "first roll");

		}
	

	@Test
	void game_manager_reports_type_of_Special_Roll() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.playerRollsDice(1,1);
		int[] newScore = manager.returnDiceRoll();
		manager.recordsTheTurnScore(newScore);
		RollTypes rollType = manager.getRollType();
		RollTypes expected = RollTypes.DOUBLE_SKUNK;
		assertEquals(expected, rollType);
		
		manager.playerRollsDice(1,2);
		newScore = manager.returnDiceRoll();
		manager.recordsTheTurnScore(newScore);
		rollType = manager.getRollType();
		expected = RollTypes.SKUNK_DEUCE;
		assertEquals(expected, rollType);
		
		manager.playerRollsDice(3,1);
		newScore = manager.returnDiceRoll();
		manager.recordsTheTurnScore(newScore);
		rollType = manager.getRollType();
		expected = RollTypes.SKUNK;
		assertEquals(expected, rollType);
		}
	
	@Test
	void game_manager_gets_total_chips_from_player() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		int playerChips = manager.getChips();
		assertEquals(50, playerChips, "default it should be 50");
	}
	
	@Test
	void GM_gets_lost_chips_from_player() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.checkRollRecord(1, 1);
		int lostChips = manager.getLostChips();
		assertEquals(4, lostChips);
	}
	
	
	@Test
	void game_manager_shares_lost_chips() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		int lostChips = manager.getLostChips();
		assertEquals(0, lostChips); //default is 0
	}
	
	@Test
	void game_manager_gets_num_players() {
		GameManager manager = new GameManager();
		int numPlayers = manager.getNumPlayers();
		assertEquals(1, numPlayers);
	}
	
	@Test
	void game_manager_gets_num_players_from_controller() {
		GameManager manager = new GameManager();
		manager.giveNumPlayers(3);
		int numPlayers = manager.getNumPlayers();
		assertEquals(3, numPlayers);
	}
	
	@Test
	void game_manager_gets_rollType_Score() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		RollTypes roll = manager.getRollType();
		assertEquals(RollTypes.NORMAL, roll); //expect default to be normal
		
		manager.checkRollRecord(1, 1);
		roll = manager.getRollType();
		assertEquals(RollTypes.DOUBLE_SKUNK, roll);
	}
	
	
	@Test
	void GM_gets_tally_from_player() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		int tally = manager.getPlayerTally();
		assertEquals(0, tally); //default is 0
	}
	
	@Test
	void GM_informs_player_of_final_score() {
		GameManager manager = new GameManager();
		manager.createPlayer("player1");
		manager.shareFinalScore(5);
		int tally = manager.getPlayerTally();
		assertEquals(5, tally); 
	}



}
