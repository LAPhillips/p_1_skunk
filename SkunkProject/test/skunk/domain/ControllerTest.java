package skunk.domain;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ControllerTest {
	
	@Test
	void controller_gets_player_name() {
		Controller control = new Controller();
		String result = control.getPlayerName();
		assertTrue( result.equals("noName"));
	}
	
	@Test
	void controller_sets_player_name() {
		Controller control = new Controller();
		String newName = "mike";
		control.setsPlayerName(newName);
		String result = control.getPlayerName();
		assertTrue( result.equals(newName));
	}
	
	@Test
	void controller_tells_manager_to_create_player() {
		Controller control = new Controller();
		String name = "george";
		control.giveNametoManager(name);
		Player player = control.getPlayer();
		assertNull(player);
	}
	

	@Test
	void controller_gets_roll_from_manager() {
		Controller control = new Controller();
		int[] dice = control.shareRoll(2,5);
		assertTrue(dice[0] == 2 && dice[1] == 5);
	}
	
	@Test
	void controller_gets_total_roll_from_manager() {
		Controller control = new Controller();
		control.shareRoll(3, 4);
		int expected = 7;
		int actual = control.rollTotal();
		assertEquals(expected, actual);
	}
	
	@Test
	void controller_gets_player_roll_input() {
		Controller control = new Controller();
		char playerDecision = control.getsPlayerDecision();
		assertTrue(playerDecision == 'Y');
	}
	
	@Test
	void controller_sets_player_roll_input() {
		Controller control = new Controller();
		char expected = 'N';
		control.setPlayerInput('N');
		char actual = control.getsPlayerDecision();
		assertEquals(expected, actual);
	}
	
	@Test
	void controller_sees_if_the_player_wants_another_round() {
		Controller control = new Controller();
		Boolean newRoll = control.startNewRoll();
		assertTrue(newRoll);
	}

	@Test
	void controller_shares_total_score() {
		Controller control = new Controller();
		int die1 = 3;
		int die2 = 4;
		int die3 = 6;
		int die4 = 7;
		control.shareRoll(die1, die2);
		control.shareRoll(die3, die4);
		int expected = die1 + die2 + die3 + die4;
		int actual = control.totalTurnScore();
		assertEquals(expected, actual);
	}

	@Test
	void controller_reports_play_by_play() {
		Controller control = new Controller();
		//for three rolls
		for (int i = 0; i < 3; i++) {
			control.shareRoll(2, 3);
		}
		int rollData = control.reportsSpecificRoll(5);
		assertEquals(3, rollData);
	}

	@Test 
	void controler_gets_number_of_rolls(){
		Controller control = new Controller();
		//for three rolls
				for (int i = 0; i < 4; i++) {
					control.shareRoll(2, 3);
				}
		int numRolls = control.numberOfRolls();
		assertEquals(4, numRolls);
	}
	
	/*
	@Test
	void controler_shares_player_chips() {
		Controller control = new Controller();
		int chips = control.getPlayerChips();
		assertEquals(50, chips);
	}
	*/
}
