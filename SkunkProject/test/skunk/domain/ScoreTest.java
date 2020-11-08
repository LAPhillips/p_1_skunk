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
		SpecialRolls expected = SpecialRolls.DOUBLE_SKUNK;
		SpecialRolls special = score.getSpecialRollType();
		assertEquals(expected, special);
	}
	
	/*
	@Test
	void score_categorizes_special_rolls() {
		Score score = new Score();
	//	int[]scores = new int[] {5,3};
		score.setTypeSpecial(scores);
		assertTrue(false);
	}*/


	
	


}
