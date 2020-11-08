package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {

	@Test
	void turn_signals_to_go_or_not() {
		Turn turn = new Turn();
		Boolean status = turn.statusTracker();
		assertFalse(status);
	}

}
