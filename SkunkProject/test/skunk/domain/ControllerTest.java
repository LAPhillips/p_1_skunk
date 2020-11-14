package skunk.domain;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ControllerTest {
	
	@Test
	void controller_gives_recieve_name_from_manager() {
		Controller control = new Controller();
		String newName = "player1";
		control.sharePlayerName(newName);
		String result = control.getPlayerNameFromManager();
		assertTrue( result.equals(newName));
	}
	
	@Test
	void controler_shares_manager() {
		Controller control = new Controller();
		GameManager manager = control.getManager();
		assertNotNull(manager);
	}
	@Test
	void controller_sets_player_roll_input() {
		Controller control = new Controller();
		GameManager manager = control.getManager();
		control.sharePlayerName("player1");
		control.sharePlayerInputs('N');	
		Boolean result = manager.getContinueTurn();
		assertFalse(result);
	}
	
	
	@Test
	void controller_gets_chips_from_manager() {
		Controller control = new Controller();
		control.sharePlayerName("joe");
		int chips = control.getPlayerChipsFromManager();
		assertEquals(50, chips, "expect 50, b/c default is 50");
	}
	
	/*
	@Test
	void controller_gets_lost_chips_from_manager() {
		Controller control = new Controller();
		control.giveNametoManager("joe");
		Player player = control.getPlayerFromManager(); 
		int lost = -5;
		player.adjustChips(lost);
		int chips = control.getLostChips();
		assertEquals(5, chips, "the amount lost will be negative");
	}*/


	@Test
	void controller_gets_roll_from_manager() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		int[] dice = control.shareRoll(2,5);
		assertTrue(dice[0] == 2 && dice[1] == 5);
	}
	
	@Test
	void controller_gets_random_roll_from_manager() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		int[] dice = control.shareRoll(2,5);
		assertTrue((dice[0] > 0 && dice[0] < 7) &&(dice[0]> 0 && dice[1] < 7));
	}
	
	@Test
	void controller_gets_total_roll_from_manager() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		control.shareRoll(3, 4);
		int expected = 7;
		int actual = control.rollTotal();
		assertEquals(expected, actual);
	}

	
	
	@Test
	void controller_sees_if_the_player_wants_another_round() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		Boolean newRoll = control.startNewRoll();
		assertTrue(newRoll);
	}

	@Test
	void controller_shares_total_score() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		int die1 = 3;
		int die2 = 4;
		control.shareRoll(die1, die2);
		
		int die3 = 6;
		int die4 = 7;
		control.shareRoll(die3, die4);
		int expected = die1 + die2 + die3 + die4;
		int actual = control.totalTurnScore();
		assertEquals(expected, actual);
	}

	@Test
	void controller_reports_play_by_play() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		//for three rolls
		for (int i = 0; i < 3; i++) {
			control.shareRoll(2, 3);
		}
		int rollData = control.reportsSpecificRoll(5);
		assertEquals(3, rollData);
	}

	@Test 
	void controller_gets_number_of_rolls(){
		Controller control = new Controller();
		control.sharePlayerName("player1");
		//for three rolls
				for (int i = 0; i < 4; i++) {
					control.shareRoll(2, 3);
				}
		int numRolls = control.numberOfRolls();
		assertEquals(4, numRolls);
	}
	
	@Test
	void controller_shares_special_rolls() {
		Controller control = new Controller();
		control.sharePlayerName("player1");
		control.shareRoll(1, 3);
		RollTypes roll = control.reportsSpecialRoll();
		RollTypes expected = RollTypes.SKUNK;
		assertEquals(roll, expected);

	}
	
	@Test
	void controller_gets_number_of_players() {
		Controller control = new Controller();
		int numberOfPlayers = control.getNumPlayers();
		assertEquals(1, numberOfPlayers); //default 1
	}
	
	@Test
	void controller_sets_number_of_players() {
		Controller control = new Controller();
		control.setNumberPlayers(3);
		int numberOfPlayers = control.getNumPlayers();
		assertEquals(3, numberOfPlayers); //default 1
	}
	
	

}
