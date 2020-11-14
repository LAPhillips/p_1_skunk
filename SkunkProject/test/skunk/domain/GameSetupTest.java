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
		setup.createPlayersInGame(3);
		assertNotNull(setup.getPlayers()); //should be initialized now
	}
	
	@Test
	void setup_can_share_new_player_from_array() {
		GameSetup setup = new GameSetup();
		setup.createPlayersInGame(3);
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
		setup.createPlayersInGame(3);
		setup.addPlayer(player);
		Player firstPlayer = setup.getSinglePlayer(0);
		assertTrue(player.equals(firstPlayer));
	}
	
	@Test
	void setup_can_create_new_player() {
		GameSetup setup = new GameSetup();
		setup.createPlayersInGame(3);
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
	


}
