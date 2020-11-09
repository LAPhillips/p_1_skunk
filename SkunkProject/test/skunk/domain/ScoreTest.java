package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {

	
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
	
	@Test
	void score_checks_for_special_rolls() {
		Score score = new Score();
		int [] firstRoll = new int[] {2,3};
		Boolean roll1 = score.isSpecial(firstRoll);
		assertFalse(roll1);
		
		int[] secondRoll = new int[] {1, 1};
		Boolean roll2 = score.isSpecial(secondRoll);
		assertTrue(roll2);
		
		int[] thirdRoll = new int[] {1, 2};
		Boolean roll3 = score.isSpecial(thirdRoll);
		assertTrue(roll3);	
	}
	
	@Test
	void score_wont_record_Special_scores() {
		Score score = new Score();
		int[]scores = new int[] {2,2};
		score.checkThenRecord(scores);
		assertEquals(4, score.getTotalScoreForTurn());
		
		int[]scores2 = new int[] {1,2};
		score.checkThenRecord(scores2);
		assertEquals(4, score.getTotalScoreForTurn());
	}	
	
	@Test
	void score_shares_type_special_rolls() {
		Score score = new Score();
		int[]scores = new int[] {1,1};
		SpecialRolls expected = null;
		SpecialRolls special = score.getSpecialRollType();
		assertEquals(expected, special);
	}
	
	@Test
	void score_categorizes_special_rolls() {
		Score score = new Score();
		int[]scores = new int[] {1,1};
		score.setTypeSpecial(scores);
		SpecialRolls special = score.getSpecialRollType();
		SpecialRolls expected = SpecialRolls.DOUBLE_SKUNK;
		assertEquals(expected, special);
		
		int[]scores2 = new int[] {1,2};
		score.setTypeSpecial(scores2);
		special = score.getSpecialRollType();
		expected = SpecialRolls.SKUNK_DEUCE;
		assertEquals(expected, special);
		
		int[]scores3 = new int[] {5,1};
		score.setTypeSpecial(scores3);
		special = score.getSpecialRollType();
		expected = SpecialRolls.SKUNK;
		assertEquals(expected, special);
	}
	
	@Test
	void score_can_get_final_score() {
		Score score = new Score();
		int finalScore = score.getFinalScore();
		assertEquals(0, finalScore);
	}	
	
	
	@Test
	void score_can_set_final_score() {
		Score score = new Score();
		int finalScore = 5;
		score.setFinalScore(finalScore);
		assertEquals(finalScore, score.getFinalScore());
	}

	@Test
	void score_voids_final_score_if_special() {
		Score score = new Score();
		int[]scores = new int[] {5,5};
		score.recordScore(scores);
		
		score.editFinalScore(scores);
		int finalScore = score.getFinalScore();
		assertEquals(10, finalScore);
		
		int[]scores3 = new int[] {2,2};
		score.recordScore(scores3);
		score.editFinalScore(scores3);
		finalScore = score.getFinalScore();
		assertEquals(14, finalScore);
		
		int[]scores2 = new int[] {1,1};
		score.recordScore(scores2);	
		score.editFinalScore(scores2);
		finalScore = score.getFinalScore();
		assertEquals(0, finalScore);
	}	

	@Test
	void score_gives_a_cumulative_score() {
		Score score = new Score();
		int expected = 10;
		int[]scores = new int[] {5,5};
		score.checkThenRecord(scores);
		int result = score.totalScore();
		assertEquals(expected, result);
	}


}
