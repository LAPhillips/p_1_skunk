package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreTest {
	
	@Test
	void score_shares_scoreboard() {
		Score score = new Score();
		ArrayList<Integer> scores = score.getScoreboard();
		assertNotNull(scores);
	}
	
	@Test
	void score_shares_FinalScore() {
		Score score = new Score();
		int finalScore = score.getFinalScore();
		assertEquals(0, finalScore); //expect default to be 0
	}
	
	@Test
	void score_shares_turnScore() {
		Score score = new Score();
		int turnScore = score.getTurnScore();
		assertEquals(0, turnScore); //expect default to be 0
	}

}
