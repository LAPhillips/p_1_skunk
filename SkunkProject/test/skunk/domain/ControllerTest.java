package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	void controller_can_get_player_from_gp() {
		Controller control = new Controller();
		Player player = control.getPlayer();
		assertTrue(player.getPlayerName().equals(" ")); //default player name is " " 
	}
	
	@Test
	void controller_can_get_current_roll_random() {
		Controller control = new Controller();
		int [] roll = control.diceRoll();
		assertTrue((roll[0] >=1 && roll[0] <= 6) && (roll[1] >=1 && roll[1] <= 6)); 
	}
	
	@Test
	void controller_can_get_roll_types() {
		Controller control = new Controller();
		control.diceRoll(1,1);
		RollTypes type = control.getRollType();
		assertEquals(RollTypes.DOUBLE_SKUNK, type); //double ones should produce double skunk
	}
	
	@Test
	void controller_gives_number_of_players_to_gp() {
		Controller control = new Controller();
		control.setNumberOfPlayers(50);
		GamePlay play = control.getGamePlay();
		assertEquals(50, play.getPlayers().length); //Players Array should have a size of 50
	}
	
	@Test
	void controller_can_give_player_names_to_gp() {
		Controller control = new Controller();
		control.setNumberOfPlayers(1);
		control.setPlayerNames("playerName");
		Player player = control.getPlayer();
		assertTrue(player.getPlayerName().equals("playerName")); //default player name is " " 
	}
	
	@Test
	void controller_sends_user_feedback_to_be_interpreted() {
		Controller control = new Controller();
		boolean decision = control.yesOrNo('y');
		assertTrue(decision); // y is true
		
		decision = control.yesOrNo('n');
		assertFalse(decision); // n is false
	}
	
	@Test
	void controller_gives_gp_turn_updates() {
		Controller control = new Controller();
		control.setNumberOfPlayers(1);
		control.setPlayerNames("playerName");
		control.isTurnOver(false); 
		Player player = control.getPlayer();
		
		assertTrue(player.getTurnStatus()); //expect turn status to still be true, because the turn is not over (false)
	
		control.isTurnOver(true);
		player = control.getPlayer();
		assertFalse(player.getTurnStatus()); //now we expect turn status to be false,because turn is over (true)
	}
	
	@Test
	void controller_asks_for_next_player() {
		Controller control = new Controller();
		control.setNumberOfPlayers(2);
		GamePlay play = control.getGamePlay();
		play.createPlayer("player1");
		play.createPlayer("player2");
		Player player = control.getPlayer();
		assertTrue(player.getPlayerName().equals("player1")); //first active player should be the first player
		
		control.nextPlayer();
		player = control.getPlayer();
		assertTrue(player.getPlayerName().equals("player2")); //after asking for next player, second player should be active
	}
	
	@Test
	void controller_reports_winner() {
		Controller control = new Controller();
		control.setNumberOfPlayers(3);
		GamePlay play = control.getGamePlay();
		play.createPlayer("player1");
		play.createPlayer("player2");
		play.createPlayer("player3");
		int[] roll = new int[]{2,2};
		Player player = control.getPlayer();
		player.updateTurnStatusAndScore(roll, false);
		control.isTurnOver(true);
		
		control.nextPlayer();
		roll = new int[]{10,10};
		player = control.getPlayer();
		player.updateTurnStatusAndScore(roll, false);
		control.isTurnOver(true);
		
		control.nextPlayer();
		roll = new int[]{5,5};
		player = control.getPlayer();
		player.updateTurnStatusAndScore(roll, false);
		control.isTurnOver(true);
		
		Player winner = control.winner();
		
		assertTrue(winner.getPlayerName().equals("player2"));// player two has the highest score, should win
	}
	
	@Test
	void controller_gets_gamePlay() {
		Controller control = new Controller();
		GamePlay play = control.getGamePlay();
		assertNotNull(play); //this method is only for testing
	}
	
	@Test
	void controller_rolls_fixed_dice() {
		Controller control = new Controller();
		int [] roll = control.diceRoll(2,3);
		assertTrue((roll[0] == 2 && roll[1] == 3)); 
	}

}
