package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	void controller_gets_player_name() {
		Controller control = new Controller();
		String result = control.getPlayerNameFromUI();
		assertTrue( result.equals("mike"));
	}

}
