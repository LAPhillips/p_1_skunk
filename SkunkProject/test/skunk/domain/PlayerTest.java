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
	void player_can_lose_chips() {
		Player player = new Player("player1");
		player.adjustChips(-5);
		int result = player.getChips();
		assertEquals(45, result);
	}
	/*
	@Test
	void player_can_gain_chips() {
		Player player = new Player("player1");
		player.adjustChips(2);
		int result = player.getChips();
		assertEquals(result, 52);
	}
	
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
