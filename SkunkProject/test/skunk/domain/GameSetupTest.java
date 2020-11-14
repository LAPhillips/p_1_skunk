package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameSetupTest {

	@Test
	void setup_can_share_players() {
		GameSetup setup = new GameSetup();
		assertNull(setup.getPlayers()); //default is null
	}

}
