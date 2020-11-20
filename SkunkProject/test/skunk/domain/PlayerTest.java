package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void player_shares_name() {
		String playerName = "playerName";
		Player player = new Player(playerName);
		String result = player.getPlayerName();
		assertTrue(playerName.equals(result));	
	}
	
	@Test
	void player_shares_lostChips() {
		Player player = new Player("playerName");
		int lostChips = player.getLostChips();
		assertEquals(0, lostChips); //default is 0
	}
	
	@Test
	void player_shares_chips() {
		Player player = new Player("playerName");
		int chips = player.getChips();
		assertEquals(50, chips); //default is 50
	}
	
	@Test
	void player_shares_turnStatus() {
		Player player = new Player("playerName");
		boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default is true
	}
	
	@Test
	void player_shares_finalTurnStatus() {
		Player player = new Player("playerName");
		boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default is true
	}
	
	@Test
	void player_shares_turnScore() {
		Player player = new Player("playerName");
		int turnScore = player.getTurnScore();
		assertEquals(0, turnScore); //default is 0
	}
	
	@Test
	void player_shares_scoreboard() {
		Player player = new Player("playerName");
		ArrayList<Integer> scoreboard = player.getScoreboard();
		assertEquals(0, scoreboard.size()); //without scores, scoreboard size is 0
	}
	
}
