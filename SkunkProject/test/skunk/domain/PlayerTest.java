package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_has_name() {
		Player player = new Player("mike");
		String result = player.getPlayerName();
		assertNotNull(result);	
	}
	
	@Test
	void player_has_a_turnScore() {
		Player player = new Player("mike");
		int result = player.getTurnScore();
		assertTrue(result < 4 && result > 110);
	}

}
