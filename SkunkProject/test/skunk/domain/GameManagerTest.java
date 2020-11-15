package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameManagerTest {

	@Test
	void setup_can_share_players() {
		GameManager setup = new GameManager();
		assertNull(setup.getPlayers()); //default is null
	}
	
	@Test
	void setup_can_initalize_new_players_array() {
		GameManager setup = new GameManager();
		setup.setupGame(3);
		assertNotNull(setup.getPlayers()); //should be initialized now
	}
	
	@Test
	void manager_can_share_new_player_from_array() {
		GameManager manager = new GameManager();
		manager.setupGame(3);
		Player[] players = manager.getPlayers();
		Player player = new Player("Player1");
		players[0] = player; //Manually adding player for the test	
		Player firstPlayer = manager.getSinglePlayer(0);
		assertTrue(player.equals(firstPlayer));
	}
	
	@Test
	void manager_can_add_new_players_array() {
		GameManager manager = new GameManager();
		Player player = new Player("Player1");
		manager.setupGame(3);
		manager.addPlayer(player);
		Player firstPlayer = manager.getSinglePlayer(0);
		assertTrue(player.equals(firstPlayer));
	}
	
	@Test
	void manager_can_create_new_player() {
		GameManager manager = new GameManager();
		manager.setupGame(3);
		manager.createPlayer("playerName");
		Player firstPlayer = manager.getSinglePlayer(0);
		assertNotNull(firstPlayer); 
	}
	
	@Test
	void manager_gets_number_of_players() {
		GameManager manager = new GameManager();
		int numPlayers = manager.getNumPlayers();
		assertEquals(1, numPlayers); //default is 1
	}
	
	@Test
	void manager_sets_number_Players_from_controller() {
		GameManager manager = new GameManager();
		manager.setupGame(3);
		assertEquals(3, manager.getNumPlayers()); 
	}
	
	@Test
	void manager_can_change_turn_status_for_all_players() {
		GameManager manager = new GameManager();
		manager.setupGame(3);
		manager.createPlayer("playerName");
		manager.createPlayer("playerName2");
		manager.createPlayer("playerName3");
		Player player = manager.getSinglePlayer(1);
		
		Boolean turnStatus = player.getTurnStatus();
		assertTrue(turnStatus); //default should be true
		
		manager.changeTurnStatus();
		player = manager.getSinglePlayer(0);
		turnStatus = player.getTurnStatus();
		
		assertFalse(turnStatus);
		
		player = manager.getSinglePlayer(1);
		turnStatus = player.getTurnStatus();
		assertFalse(turnStatus);
		
		player = manager.getSinglePlayer(2);
		turnStatus = player.getTurnStatus();
		assertFalse(turnStatus);
	}
	
	@Test
	void game_manager_gives_turn_Manager() {
		GameManager manager = new GameManager();
		TurnManager turnManage = manager.getTurnManager();
		assertNotNull(turnManage);
	}
	
}
