package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnScoreTest {

	@Test
	void every_turn_has_a_score_after_each_roll() {
		TurnScore scoreAfterRoll = new TurnScore();
		int result = scoreAfterRoll.getScoreAfterRoll();
		assertTrue(result > 0 && result < 12);
	}

}
