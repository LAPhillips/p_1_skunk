package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
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
		int [] fixedArray = {2,4,6,8};
		dice.roll(fixedArray);
		int result = dice.getLastRoll();
		assertTrue(result == 4);
	}
	
	@Test
	void dice_should_produce_two_fixed_numbers_from_array_in_roll_after_roll() {
		Dice dice = new Dice();
		int [] fixedArray = {2,4,6,8};
		int [] actualRolls = {0,0,0,0};
		for (int i = 0; i < fixedArray.length; i++) {
			dice.roll(fixedArray);
			int result = dice.getLastRoll();
			actualRolls[i] = result/2;
		}
		Assert.assertArrayEquals(fixedArray, actualRolls);
	}
	

}
