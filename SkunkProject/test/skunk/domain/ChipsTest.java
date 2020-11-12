package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChipsTest {

	@Test
	void chips_has_number_of_chips() {
		Chips chips = new Chips();
		int startingChips = chips.getNumChips();
		assertEquals(50, startingChips);
	}

}
