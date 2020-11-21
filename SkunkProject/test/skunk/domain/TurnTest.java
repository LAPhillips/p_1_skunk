package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {

	@Test
	void turn_gives_turn_status() {
		Turn turn = new Turn();
		Boolean status = turn.getTurnStatus();
		assertTrue(status); //default should be true
	}
	
	@Test
	void turn_ends_turn() {
		Turn turn = new Turn();
		turn.endTurn();
		Boolean status = turn.getTurnStatus();
		assertFalse(status); //expect turn status to be negative because turn is over
	}
	
	@Test
	void turn_starts_turn() {
		Turn turn = new Turn();
		turn.endTurn();
		Boolean status = turn.getTurnStatus();
		assertFalse(status); //making sure it is false

		turn.startNewTurn();
		status = turn.getTurnStatus();
		assertTrue(status); //now turn Status should be true again
	}
	
	@Test
	void turn_gives_Finalturn_status() {
		Turn turn = new Turn();
		Boolean status = turn.getFinalTurn();
		assertTrue(status); //default should be true
	}
	
	@Test
	void turn_updates_Finalturn_status() {
		Turn turn = new Turn();
		turn.updateFinalTurn(); 
		Boolean status = turn.getFinalTurn();
		assertFalse(status); // when updated, the final turn should be false
	}
	
	

}
