package skunk.domain;
import static org.junit.jupiter.api.Assertions.*;
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
	void controller_gets_roll_from_manager() {
		Controller control = new Controller();
		int[] dice = control.shareRoll(2,5);
		assertTrue(dice[0] == 2 && dice[1] == 5);
	}
	
	


}
