package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myskunk.pl.SkunkUI;

class ControllerTest {

	@Test
	void controller_gets_player_name() {
		Controller control = new Controller();
		SkunkUI ui = new SkunkUI();
		String result = control.getPlayerNameFromUI();
		String enteredResult = ui.getEnteredName();
		assertTrue( result.equals(enteredResult));
	}

}
