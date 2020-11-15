package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameSetupTest {

	@Test
	void setup_can_share_players() {
		GameSetup setup = new GameSetup();
		assertNull(setup.getPlayers()); //default is null
	}
	
	@Test
	void setup_can_initalize_new_players_array() {
		GameSetup setup = new GameSetup();
		setup.setupGame(3);
		assertNotNull(setup.getPlayers()); //should be initialized now
	}
	
	@Test
	void setup_can_share_new_player_from_array() {
		GameSetup setup = new GameSetup();
		setup.setupGame(3);
		Player[] players = setup.getPlayers();
		Player player = new Player("Player1");
		players[0] = player; //Manually adding player for the test	
		Player firstPlayer = setup.getSinglePlayer(0);
		assertTrue(player.equals(firstPlayer));
	}
	
	@Test
	void setup_can_add_new_players_array() {
		GameSetup setup = new GameSetup();
		Player player = new Player("Player1");
		setup.setupGame(3);
		setup.addPlayer(player);
		Player firstPlayer = setup.getSinglePlayer(0);
		assertTrue(player.equals(firstPlayer));
	}
	
	@Test
	void setup_can_create_new_player() {
		GameSetup setup = new GameSetup();
		setup.setupGame(3);
		setup.createPlayer("playerName");
		Player firstPlayer = setup.getSinglePlayer(0);
		assertNotNull(firstPlayer); 
	}
	
	@Test
	void setup_gets_number_of_players() {
		GameSetup setup = new GameSetup();
		int numPlayers = setup.getNumPlayers();
		assertEquals(1, numPlayers); //default is 1
	}
	
	@Test
	void setup_sets_number_Players_from_controller() {
		GameSetup setup = new GameSetup();
		setup.setupGame(3);
		assertEquals(3, setup.getNumPlayers()); 
	}
	
	@Test
	void setup_can_change_turn_status_for_all_players() {
		GameSetup setup = new GameSetup();
		setup.setupGame(3);
		setup.createPlayer("playerName");
		setup.createPlayer("playerName2");
		setup.createPlayer("playerName3");
		Player player = setup.getSinglePlayer(1);
		
		Boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default should be true
		
		setup.changeTurnStatus();
		player = setup.getSinglePlayer(0);
		turnStatus = player.getTurnStatus();
		
		assertFalse(turnStatus);
		
		player = setup.getSinglePlayer(1);
		turnStatus = player.getTurnStatus();
		assertFalse(turnStatus);
		
		player = setup.getSinglePlayer(2);
		turnStatus = player.getTurnStatus();
		assertFalse(turnStatus);
	}
	
}
