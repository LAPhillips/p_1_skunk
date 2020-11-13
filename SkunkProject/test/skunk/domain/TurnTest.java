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
	
	@Test
	void turn_changes_status() {
		Turn turn = new Turn();
		turn.endTurn();
		Boolean status = turn.getTurnStatus();
		assertFalse(status);
	}
	
	@Test
	void turn_tracks_number_of_turns() {
		Turn turn = new Turn();
		int numberOfTurns = turn.getnumberOfTurns();
		assertEquals(1, numberOfTurns);
	}
	
	@Test
	void when_new_turn_starts_counter_increases() {
		Turn turn = new Turn();
		turn.endTurn();
		turn.startNewTurn();
		int numberOfTurns = turn.getnumberOfTurns();
		assertEquals(2, numberOfTurns);
	}
}
