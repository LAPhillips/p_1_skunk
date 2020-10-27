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
		scores.recordRoll(6);
		assertTrue(turnscore.size() == 1);
		
	}

}
