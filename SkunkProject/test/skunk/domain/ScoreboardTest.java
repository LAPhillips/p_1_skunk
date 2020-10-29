package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreboardTest {

	@Test
	void scoreboard_get_turn_scores() {
		Scoreboard scores = new Scoreboard();
		ArrayList<Integer> turnscore = scores.getTurnScores();
		turnscore.add(2);
		assertFalse(turnscore.isEmpty());
	}
	
	
	@Test
	void scoreboard_records_roll() {
		Scoreboard scores = new Scoreboard();
		ArrayList<Integer> turnscore = scores.getTurnScores();
		int[] newScore = new int[] {3,2};
		scores.recordRoll(newScore);
		assertTrue(turnscore.size() == 2);
	}
	
	@Test
	void scoreboard_get_specific_score() {
		Scoreboard scores = new Scoreboard();
		ArrayList<Integer> turnscore = scores.getTurnScores();
		turnscore.add(2);
		turnscore.add(3);
		turnscore.add(7);
		assertEquals(7, scores.getSpecificTurnScores(2));
	}

}
