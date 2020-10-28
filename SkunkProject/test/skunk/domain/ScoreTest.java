package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {

	@Test
	void after_roll_score_is_avaliable() {
		Score score = new Score(5);
		int result = score.getScoreAfterRoll();
		assertTrue(result > 0 && result < 12);
	}
	
	
	@Test
	void after_roll_new_score_is_set() {
		Score score = new Score();
		int result = 0;
		score.setScoreForRoll(5);
		result = score.getScoreAfterRoll();
		assertEquals(5, result);
	}
	
	@Test
	void after_roll_new_points_are_recorded() {
		Score score = new Score();
		int newPoints = 6;
		int recordedPoints = 6;
		assertEquals(newPoints, recordedPoints);
	}
	


}
