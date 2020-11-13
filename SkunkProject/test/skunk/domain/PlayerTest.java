package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

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
	void player_records_most_current_score() {
		Player player = new Player("player1");
		int[] newScore = new int[] {3,4};
		player.recordScore(newScore);
		int score = player.getIndividualScore();
		assertEquals(7, score); 
	}
	
	@Test
	void player_shares_most_current_score() {
		Player player = new Player("player1");
		int score = player.getIndividualScore();
		assertEquals(0, score); //default score is 0
	}
	
	

	/*
	@Test
	void player_sets_chips() {
		Player player = new Player("player1");
		player.setChips(55);
		int result = player.getLostChips();
		assertEquals(result, 5);
	}
	
	@Test
	void player_keeps_track_of_lost_chips() {
		Player player = new Player("player1");
		player.setChips(50);
		player.adjustChips(1);
		player.adjustChips(-5);
		int result = player.getLostChips();
		assertEquals(result, 4);
	}
	

	*/
	
	

}
