package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnScoreTest {

	@Test
	void every_turn_can_return_a_score_after_roll() {
		TurnScore score = new TurnScore(5);
		int result = score.getScoreAfterRoll();
		assertTrue(result > 0 && result < 12);
	}
	
	
	@Test
	void every_turn_records_a_score_after_roll() {
		TurnScore score = new TurnScore();
		int result = 0;
		score.setScoreForRoll(5);
		result = score.getScoreAfterRoll();
		assertEquals(5, result);
	}

}
