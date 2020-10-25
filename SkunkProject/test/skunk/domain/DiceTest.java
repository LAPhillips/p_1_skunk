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
	
	@Test
	void dice_should_produce_two_fixed_numbers_from_array() {
		Dice dice = new Dice();
		int [] diceArray = {2,4,6,8};
		dice.roll(diceArray);
		int result = dice.getLastRoll();
		assertTrue(result == 4);
	}
	

}
