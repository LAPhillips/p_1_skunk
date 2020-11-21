package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RollTypesTest {

	@Test
	void rt_shares_correct_string_for_skunk() {
		RollTypes type = RollTypes.SKUNK;
		String expected = "Sorry, you rolled a Skunk! Your turn ends, and you lose 1 Chip.";
		assertTrue(type.toString().equals(expected));
	}
	
	@Test
	void rt_shares_correct_string_for_double_skunk() {
		RollTypes type = RollTypes.DOUBLE_SKUNK;
		String expected =  "Sorry, you rolled Two Skunks! Your turn ends, you lose all your points, and you lose 4 Chips.";
		assertTrue(type.toString().equals(expected));
	}
	
	@Test
	void rt_shares_correct_string_for_deuce_skunk() {
		RollTypes type = RollTypes.SKUNK_DEUCE;
		String expected =   "Sorry, you rolled a Skunk and Deuce! Your turn ends, and you lose 2 Chips";
		assertTrue(type.toString().equals(expected));
	}
	
	@Test
	void rt_shares_correct_string_for_normal() {
		RollTypes type = RollTypes.NORMAL;
		String expected =   "Nice roll!";
		assertTrue(type.toString().equals(expected));
	}

}
