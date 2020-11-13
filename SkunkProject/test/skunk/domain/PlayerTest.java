package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_has_name() {
		Player player = new Player("player1");
		String result = player.getPlayerName();
		assertNotNull(result);	
	}
	
	@Test
	void player_has_chips() {
		Player player = new Player("player1");
		int result = player.getChips();
		assertEquals(50, result);
	}
	
	@Test
	void player_can_share_lost_or_gained_chips() {
		Player player = new Player("player1");
		int result = player.getLostChips();
		assertEquals(0, result); //default is 0
	}
	
	@Test
	void player_can_gives_roll_type_to_chips() {
		Player player = new Player("player1");
		player.givesChipsRollType(RollTypes.SKUNK);
		int result = player.getLostChips();
		assertEquals(-1, result); //skunk is -1
		
		player.givesChipsRollType(RollTypes.DOUBLE_SKUNK);
		result = player.getLostChips();
		assertEquals(-4, result); //double Skunk is -4
		
		
		player.givesChipsRollType(RollTypes.SKUNK_DEUCE);
		result = player.getLostChips();
		assertEquals(-2, result); //skunk and deuce is -2
	}
	
	@Test
	void player_gets_roll_type() {
		Player player = new Player("player1");
		RollTypes type = player.getRollType();
		assertEquals(RollTypes.NORMAL, type); //default score is 0
	}
	
	@Test
	void player_gives_roll_to_chips_gets_back() {
		Player player = new Player("player1");
		int[] newScore = new int[] {1,1};
		int change = player.chipsFlow(newScore);
		assertEquals(-4, change); //would expect -4 for double skunk
	}
	
	@Test
	void player_updates_roll_type() {
		Player player = new Player("player1");
		player.setRollType(RollTypes.SKUNK);
		RollTypes type = player.getRollType();
		assertEquals(RollTypes.SKUNK, type); //default score is 0
	}
	
	@Test
	void player_records_most_current_score() {
		Player player = new Player("player1");
		int[] newScore = new int[] {3,4};
		player.recordScore(newScore);
		int score = player.getFinalScore();
		assertEquals(7, score); 
	}
	
	@Test
	void player_shares_scoreboard() {
		Player player = new Player("player1");
		int[] newScore = new int[] {3,4};
		player.recordScore(newScore);
		ArrayList<Integer> playerSB = player.getScoreboard();
		assertEquals(4, playerSB.get(1));
		
		int[] newScore2 = new int[] {9,3};
		player.recordScore(newScore2);
		playerSB = player.getScoreboard();
		assertEquals(9, playerSB.get(2));
	}
	
	@Test
	void player_shares_most_final_score() {
		Player player = new Player("player1");
		int score = player.getFinalScore();
		assertEquals(0, score); //default score is 0
		
		int[] roll = new int[] {2,3};
		player.recordScore(roll);
		score = player.getFinalScore();
		assertEquals(5, score);
		
		
		
		
	}
	
	@Test
	void player_gets_the_current_dice_roll() {
		Player player = new Player("player1");
		int [] roll = player.getCurrentRoll();
		assertNull(roll); //default is null
	}
	
	@Test
	void player_sets_the_current_dice_roll() {
		Player player = new Player("player1");
		int[] roll = new int[] {2,3};
		player.setCurrentRoll(roll);
		int [] newRoll = player.getCurrentRoll();
		assertEquals(roll[1], newRoll[1]);
	}
	
	@Test
	void player_gets_rollType_from_score() {
		Player player = new Player("player1");
		int[] roll = new int[] {1,1};
		RollTypes type = player.getRollTypeFromScore(roll);
		assertEquals(RollTypes.DOUBLE_SKUNK, type); //expect a double skunk
	}


}
