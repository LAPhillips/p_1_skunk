package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {
	
	@Test
	void score_shares_scoreboard() {
		Score score = new Score();
		int[]scores = new int[] {5,3};
		score.recordScore(scores);
		ArrayList<Integer> retreivedScore = score.getScoreboard();
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
		int result = score.allRollsOneTurn();
		assertEquals(expected, result);
	}	
	
	@Test
	void score_can_get_final_score() {
		Score score = new Score();
		int finalScore = score.getFinalScore();
		assertEquals(0, finalScore);
	}	

	@Test
	void score_gives_a_cumulative_score() {
		Score score = new Score();
		int expected = 10;
		int[]scores = new int[] {5,5};
		score.recordScore(scores);
		int result = score.getFinalScore();
		assertEquals(expected, result);
	}
}
