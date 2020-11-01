package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {

	@Test
	void after_roll_score_is_avaliable() {
		Score score = new Score(5);
		int result = score.getTotalScoreForRoll();
		assertTrue(result > 0 && result < 12);
	}	
	
	@Test
	void after_roll_new_score_is_set() {
		Score score = new Score();
		int result = 0;
		score.setScoreForRoll(5);
		result = score.getTotalScoreForRoll();
		assertEquals(5, result);
	}
	
	@Test
	void score_can_record_score_from_scoreboard() {
		Score score = new Score();
		int[]scores = new int[] {5,3};
		score.recordScore(scores);
		int recordedScore = score.getSpecificRecordedScore(1);
		assertEquals(recordedScore, 3);
	}
	
	@Test
	void score_shares_scoreboard() {
		Score score = new Score();
		int[]scores = new int[] {5,3};
		score.recordScore(scores);
		ArrayList<Integer> retreivedScore = score.getTurnScores();
		assertEquals(scores[1], retreivedScore.get(1));
	}	
	


}
