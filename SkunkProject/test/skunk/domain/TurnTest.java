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
	void player_can_end_turn() {
		Turn turn = new Turn();
		char playerInput = 'N';
		turn.playersDecision(playerInput);
		Boolean status = turn.getTurnStatus();
		assertFalse(status);
	}
}
