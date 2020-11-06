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
		assertTrue(result >= 0 && result <= 50);
	}
	
	@Test
	void player_can_lose_chips() {
		Player player = new Player("player1");
		player.removeChips(2);
		int result = player.getChips();
		assertEquals(result, 48);
	}

}
