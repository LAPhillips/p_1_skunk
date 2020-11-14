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
	//*************chips*************************************************************
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
	void player_gives_roll_to_chips_gets_back() {
		Player player = new Player("player1");
		RollTypes type = RollTypes.DOUBLE_SKUNK;
		int change = player.chipsFlow(type);
		assertEquals(-4, change); //would expect -4 for double skunk
	}
	
	//*************final Score*************************************************************
	@Test
	void player_gets_ongoing_score() {
		Player player = new Player("player1");
		int score = player.getTally();
		assertEquals(0, score); //default score is 0
	}
	
	@Test
	void player_updates_ongoing_score() {
		Player player = new Player("player1");
		player.updateTally(4);
		int score = player.getTally();
		assertEquals(4, score); //default score is 0
	}
	
	//*************managing turn*************************************************************

	@Test
	void player_gets_turn_status() {
		Player player = new Player("player1");
		Boolean turn = player.getTurnStatus();
		assertTrue(turn); //default is true
	}
	
	@Test
	void player_ends_turn() {
		Player player = new Player("player1");
		player.endTurn();
		Boolean turn = player.getTurnStatus();
		assertFalse(turn); //after endTurn() players turn status should be false
	}
	
	@Test
	void player_gets_starts_new_turn() {
		Player player = new Player("player1");
		player.endTurn();
		Boolean turn = player.getTurnStatus();
		assertFalse(turn); //after endTurn() players turn status should be false
		
		player.startTurn();
		turn = player.getTurnStatus();
		assertTrue(turn); //when starting new turn it should be true
	}
}
