package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//each player has one chips class
class ChipsTest {

	@Test
	void chips_has_number_of_chips() {
		Chips chips = new Chips();
		int startingChips = chips.getNumChips();
		assertEquals(50, startingChips);
	}
	
	@Test
	void chips_adjusts_chips() {
		Chips chips = new Chips();
		chips.adjustChips(-5);
		int startingChips = chips.getNumChips();
		assertEquals(45, startingChips);
	}
	
	@Test
	void chips_reports_lost_and_gained_chips() {
		Chips chips = new Chips();
		int change = chips.amountChange();
		assertEquals(0, change);
	}
	
	@Test
	void chips_calculates_lost_or_gained_chips() {
		Chips chips = new Chips();
		chips.calculateChipChange(RollTypes.SKUNK);
		int change = chips.amountChange();
		assertEquals(-1, change);
	}

}
