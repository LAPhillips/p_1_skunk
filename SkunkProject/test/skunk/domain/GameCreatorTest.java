package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameCreatorTest {

	@Test
	void game_creator_makes_players() {
		GameCreator creator = new GameCreator();
		assertNotNull(creator.createPlayer("player 1"));
	}
	
	@Test
	void game_creator_gets_player_name_from_UI() {
		GameCreator creator = new GameCreator();
		String playerName = creator.getPlayerName();
		assertTrue(playerName.equals("mike"));
	}

}
