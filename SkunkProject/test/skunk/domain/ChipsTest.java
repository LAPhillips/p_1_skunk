package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//each player has one chips class
class ChipsTest {

	@Test
	void chips_gets_number_of_chips() {
		Chips chip = new Chips();
		int startingChips = chip.getChips();
		assertEquals(50, startingChips); //default is 50
	}
	
	@Test
	void chips_subtracts_chips() {
		Chips chip = new Chips();
		chip.subtractChips(5);
		int chips = chip.getChips();
		assertEquals(45, chips); //after subtracting 5, should have 45 chips
	}
	
	@Test
	void chips_reports_lostChips() {
		Chips chip = new Chips();
		chip.subtractChips(5);
		int lostChips = chip.lostChips();
		assertEquals(5, lostChips); //should have lost 5 chips
	}
	
	@Test
	void chips_calculates_lost_chips_based_on_rollType() {
		Chips chips = new Chips();
		
		int skunk = chips.calculateChipChange(RollTypes.SKUNK);
		assertEquals(1, skunk); //skunk removes 1 chip from player
		
		int doubleSkunk = chips.calculateChipChange(RollTypes.DOUBLE_SKUNK);
		assertEquals(4, doubleSkunk); //double skunk removes 4 chips from player
		
		int skunkDeuce = chips.calculateChipChange(RollTypes.SKUNK_DEUCE);
		assertEquals(2, skunkDeuce); //skunk and deuce removes 2 chips from player
		
		int normal = chips.calculateChipChange(RollTypes.NORMAL);
		assertEquals(0, normal); //normal rolls remove no chips
	}
	
	@Test
	void chips_updates_number_of_chips_based_on_roll_type() {
		Chips chip = new Chips();
		chip.adjustChipsForRoll(RollTypes.SKUNK);
		int chips = chip.lostChips();
		assertEquals(1, chips); //a skunk should remove one chip
		
		chip.adjustChipsForRoll(RollTypes.DOUBLE_SKUNK);
		chips = chip.lostChips();
		assertEquals(5, chips); //a double skunk adds 4 onto the total (1 + 4 = 5)
		
		chip.adjustChipsForRoll(RollTypes.SKUNK_DEUCE);
		chips = chip.lostChips();
		assertEquals(7, chips); //a Skunk deuce adds 2 onto the total (1 + 4 + 2 = 7)
		
		chip.adjustChipsForRoll(RollTypes.NORMAL);
		chips = chip.lostChips();
		assertEquals(7, chips); //a normal roll should not change the total
		
	}
	
	
	
	
	
}
