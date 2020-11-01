package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {
	
	@Test
	void after_roll_score_is_avaliable() {
		Score score = new Score();
		int expected1 = 4;
		int expected2 = 5;
		int [] firstRoll = new int[] {2,3};
		score.recordScore(firstRoll);
		int [] secondRoll = new int[] {expected1, expected2};
		score.recordScore(secondRoll);
		int result = score.getTotalScoreForRoll();
		assertEquals((expected1+expected2), result);
	}	
	
	@Test
	void score_can_get_last_two_recorded() {
		Score score = new Score();
		int expected1 = 4;
		int expected2 = 5;
		int [] firstRoll = new int[] {2,3};
		score.recordScore(firstRoll);
		int [] secondRoll = new int[] {expected1, expected2};
		score.recordScore(secondRoll);
		int [] lastTwo = score.getLastTwoRecorded();
		assertEquals(expected1, lastTwo[0]);
	}
	
	/*
	@Test
	void after_roll_new_score_is_set() {
		Score score = new Score();
		int result = 0;
		score.setScoreForRoll(5);
		result = score.getTotalScoreForRoll(); 
		assertEquals(5, result);
	}*/
	
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
	
	@Test
	void score_keeps_a_running_tally_for_turn() {
		Score score = new Score();
		int expected1 = 4;
		int expected2 = 5;
		int [] firstRoll = new int[] {2,3};
		score.recordScore(firstRoll);
		int [] secondRoll = new int[] {expected1, expected2};
		score.recordScore(secondRoll);
		int expected = expected1 + expected2 + 2 + 3;
		int result = score.getTotalScoreForTurn();
		assertEquals(expected, result);
	}	
	


}
