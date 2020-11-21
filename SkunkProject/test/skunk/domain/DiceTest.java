package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DiceTest {
	
	@Test
	void dice_should_get_lastRollAmount() {
		Dice dice = new Dice();
		int lastRoll = dice.getLastRoll();
		assertEquals(0, lastRoll); //default lastRoll is 0
	}
	
	@Test
	void dice_should_get_bothDie() {
		Dice dice = new Dice();
		int[] dicePair = dice.getDicePair();
		assertTrue(dicePair[0] == 0 && dicePair[1] == 0); //default has both dice set to 0
	}
	
	@Test
	void dice_should_produce_two_random_numbers() {
	Dice dice = new Dice();
	dice.roll();
	int result = dice.getLastRoll();
	assertTrue(result > 0 && result < 13);
	}
	
	@Test
	void dice_should_produce_two_fixed_numbers() {
		Dice dice = new Dice();
		dice.roll(1, 4);
		int result = dice.getLastRoll();
		assertTrue(result == 5);
	}
	
	@Test
	void dice_should_print_correctly() {
		Dice dice = new Dice();
		dice.roll(1, 4);
		String printDice = "First Die: 1   Second Die: 4    Roll Total: 5";
		assertTrue(printDice.equals(dice.toString()));
	}
	
	
}
