package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {

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
		dice.roll(1, 1);
		int result = dice.getLastRoll();
		assertTrue(result == 2);
	}
	

}
