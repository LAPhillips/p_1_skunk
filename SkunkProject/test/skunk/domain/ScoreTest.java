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
	
	@Test
	void score_records_score() {
		Score score = new Score();
		int[] newRoll = new int[] {3,2};
		score.recordScore(newRoll);
		ArrayList<Integer> scores = score.getScoreboard();
		assertTrue(scores.get(0) == 3 && scores.get(1) == 2); //expect index 0 to be 3, index 1 to 2
	}
	
	@Test
	void score_adds_to_score() {
		Score score = new Score();
		score.addToScore(3);
		int turnScore = score.getTurnScore();
		assertEquals(3, turnScore); //turn score should be 3 after adding it
		
		score.addToScore(5);
		turnScore = score.getTurnScore();
		assertEquals(8, turnScore); //turn score should be 8 after adding it
	}
	
	@Test
	void score_updates_TurnScore_differently_for_specialRolls() {
		Score score = new Score();
		int[] newRoll = new int[] {3,2};
		score.updateTurnScore(newRoll, false); //3,2 is not a specialRoll
		int turnScore = score.getTurnScore();
		assertEquals(5, turnScore); //expect default to be 5 (3+2)
		
		int[] newRoll2 = new int[] {1,1};
		score.updateTurnScore(newRoll2, true); //1,1 is double skunk
		turnScore = score.getTurnScore();
		assertEquals(0, turnScore); //turn score should be 0 after special roll
	}
	
	@Test
	void score_updates_scoreboard_for_new_turn() {
		Score score = new Score();
		int[] newRoll = new int[] {3,2};
		score.recordScore(newRoll);
		ArrayList<Integer> scores = score.getScoreboard();
		assertEquals(2, scores.size()); //after adding 2, size should be 2
		
		score.startNewTurn();
		scores = score.getScoreboard();
		assertEquals(0, scores.size()); //after starting new turn, array should be empty
	}
	
	@Test
	void score_updates_finalScore() {
		Score score = new Score();
		score.addToScore(3);
		score.addToScore(3);
		score.addToScore(4); //10 points added for this turn
		
		score.updateFinalScore();
		int finalScore = score.getFinalScore();
		assertEquals(10, finalScore); //expect score to be 10 after turn
	}
	
	@Test
	void score_can_void_FinalScore() {
		Score score = new Score();
		score.addToScore(3);
		score.addToScore(3);
		score.addToScore(4); //10 points added for this turn
		
		score.updateFinalScore();
		int finalScore = score.getFinalScore();
		assertEquals(10, finalScore); //expect score to be 10 after turn
		
		score.updateForDoubleSkunk();
		finalScore = score.getFinalScore();
		assertEquals(0, finalScore); //expect score to be set to 0
		
	}
	
	

}
