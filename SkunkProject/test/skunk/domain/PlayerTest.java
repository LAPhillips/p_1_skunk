package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_shares_name() {
		String playerName = "playerName";
		Player player = new Player(playerName);
		String result = player.getPlayerName();
		assertTrue(playerName.equals(result));	
	}
	
	@Test
	void player_shares_lostChips() {
		Player player = new Player("playerName");
		int lostChips = player.getLostChips();
		assertEquals(0, lostChips); //default is 0
	}
	
	@Test
	void player_shares_chips() {
		Player player = new Player("playerName");
		int chips = player.getChips();
		assertEquals(50, chips); //default is 50
	}
	
	@Test
	void player_shares_turnStatus() {
		Player player = new Player("playerName");
		boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default is true
	}
	
	@Test
	void player_shares_finalTurnStatus() {
		Player player = new Player("playerName");
		boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default is true
	}
	
	@Test
	void player_shares_turnScore() {
		Player player = new Player("playerName");
		int turnScore = player.getTurnScore();
		assertEquals(0, turnScore); //default is 0
	}
	
	@Test
	void player_shares_scoreboard() {
		Player player = new Player("playerName");
		ArrayList<Integer> scoreboard = player.getScoreboard();
		assertEquals(0, scoreboard.size()); //without scores, scoreboard size is 0
	}
	
	@Test
	void player_shares_lostChips_based_on_roll() {
		Player player = new Player("playerName");
		
		int skunk = player.chipsLostPerRollType(RollTypes.SKUNK);
		assertEquals(1, skunk); //skunk removes 1 chip from player
		
		int doubleSkunk = player.chipsLostPerRollType(RollTypes.DOUBLE_SKUNK);
		assertEquals(4, doubleSkunk); //double skunk removes 4 chips from player
		
		int skunkDeuce = player.chipsLostPerRollType(RollTypes.SKUNK_DEUCE);
		assertEquals(2, skunkDeuce); //skunk and deuce removes 2 chips from player
		
		int normal = player.chipsLostPerRollType(RollTypes.NORMAL);
		assertEquals(0, normal); //normal rolls remove no chips
	}
	
	@Test
	void player_can_add_chips() {
		Player player = new Player("playerName");
		int baseChips = player.getChips();
		int chipsAdded = 3;
		player.addChips(chipsAdded);
		int chips = player.getChips();
		assertEquals((baseChips+chipsAdded), chips); //should be 53 chips
	}
	
	@Test
	void player_can_remove_chips() {
		Player player = new Player("playerName");
		int baseChips = player.getChips();
		int chipsRemoved = 1;
		player.subtractChips(chipsRemoved);
		int chips = player.getChips();
		assertEquals((baseChips-chipsRemoved), chips); //should be 49 chips
	}
	
	@Test
	void player_can_update_chips_for_special_rolls() {
		Player player = new Player("playerName");
		
		player.updateForSpecial(RollTypes.SKUNK);
		int skunk = player.getLostChips();
		assertEquals(1, skunk); //skunk removes 1 chip from player
		
		player.updateForSpecial(RollTypes.DOUBLE_SKUNK);
		int doubleSkunk = player.getLostChips();
		assertEquals(5, doubleSkunk); //a double skunk adds 4 onto the total (1 + 4 = 5)
		
		player.updateForSpecial(RollTypes.SKUNK_DEUCE);
		int skunkDeuce = player.getLostChips();
		assertEquals(7, skunkDeuce); //a Skunk deuce adds 2 onto the total (1 + 4 + 2 = 7)
		
		player.updateForSpecial(RollTypes.NORMAL);
		int normal = player.getLostChips();
		assertEquals(7, normal); //a normal roll should not change the total
	}
		
	@Test
		void player_can_update_finalScore_for_DoubleSkunk() {
			Player player = new Player("playerName");
			int[] newRoll = new int[] {3,3};
			player.updateTurnStatusAndScore(newRoll, false);
			player.updateForSpecial(RollTypes.NORMAL);
			player.endTurn();
			int score = player.getFinalScore(); 
			assertEquals(6, score); //expect it to be 3+3
			
			int[] newRoll2 = new int[] {1,1};
			player.updateTurnStatusAndScore(newRoll2, false);
			player.endTurn();
			player.updateForSpecial(RollTypes.DOUBLE_SKUNK);
			score = player.getFinalScore(); 
			assertEquals(0, score); //a double skunk should set score to 0
		}
	
	@Test
	void player_updates_score_and_status_by_end_turn() {
		Player player = new Player("playerName");
		int[] newRoll = new int[] {2,3};
		player.updateTurnStatusAndScore(newRoll, false);
		player.endTurn();
		int score = player.getFinalScore(); 
		boolean status = player.getTurnStatus();
		assertTrue(score == 5 && status == false); //expect it to 5 after first turn
		
		player.startTurn(); //have to reset the turnscore to 0
		int[] newRoll2 = new int[] {5,5};
		player.updateTurnStatusAndScore(newRoll2, false);
		player.endTurn();
		score = player.getFinalScore(); 
		status = player.getTurnStatus();
		assertTrue(score == 15 && status == false); //expect it to be 15 after second turn
	}
	
	@Test
	void player_updates_score_and_status_by_starting_turn() {
		Player player = new Player("playerName");
		int[] newRoll = new int[] {2,3};
		player.updateTurnStatusAndScore(newRoll, false);
		player.endTurn();
		int score = player.getTurnScore();
		boolean status = player.getTurnStatus();
		assertTrue(score == 5 && status == false); //after endTurn - score should be recorded/status should be false
		
		player.startTurn(); //have to reset the turnscore to 0
		score = player.getTurnScore();
		status = player.getTurnStatus();
		assertTrue(score == 0 && status == true); //after startTurn - score should be reset to 0/status should be true
	}

	@Test
	void player_checks_for_final_round() {
		Player player = new Player("playerName");
		int[] newRoll = new int[] {2,3};
		player.updateTurnStatusAndScore(newRoll, false);
		player.endTurn();
		player.checkForFinalTurn();
		boolean status = player.getFinalTurn();
		assertTrue(status);
		
		int[] newRoll2 = new int[] {55,55}; //for brevity sake, making huge die rolls to introduce higher score
		player.updateTurnStatusAndScore(newRoll2, false);
		player.endTurn();
		player.checkForFinalTurn();
		status = player.getFinalTurn();
		assertFalse(status); //after the player score is over 100, final turn should become false
	}
	
	@Test
	void player_updates_final_turn() {
		Player player = new Player("playerName");
		boolean status = player.getFinalTurn();
		assertTrue(status); //default should be true
		
		player.updateFinalTurn(); //updating should make it false
		status = player.getFinalTurn();
		assertFalse(status); //now it is false
	}
	
	@Test
	void player_updates_dice() {
		Player player = new Player("playerName");
		int[] roll = new int[] {2,3};
		player.playerGetsDiceRoll(roll);
		player.playerGetsDiceRoll(roll);
		player.playerGetsDiceRoll(roll); //6 scores have been added to the scoreboard
		ArrayList<Integer> scores = player.getScoreboard();
		assertEquals(6, scores.size()); // expect the scores Array to have 6 items in it
	}
	
	@Test
	void player_updates_turnscore_and_status() {
		Player player = new Player("playerName");
		int[] newRoll = new int[] {2,3};
		player.updateTurnStatusAndScore(newRoll, false); //if it is not special, the score should be 5
		int score = player.getTurnScore();
		boolean status = player.getTurnStatus();
		assertTrue(score == 5 && status == true); //not special, status remains unchanged
		
		newRoll = new int[] {1,1};
		player.updateTurnStatusAndScore(newRoll, true); //score set to 0 and status is changed when special
		score = player.getTurnScore();
		status = player.getTurnStatus();
		assertTrue(score == 0 && status == false); //not special, status remains unchanged
	}

}
