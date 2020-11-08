package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {

	@Test
	void turn_gives_turn_status() {
		Turn turn = new Turn();
		Boolean status = turn.getTurnStatus();
		assertTrue(status);
	}

}
