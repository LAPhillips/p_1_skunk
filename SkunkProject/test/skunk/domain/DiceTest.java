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
		dice.rollInDoubles(fixedArray);
		int result = dice.getLastRoll();
		assertTrue(result == 4);
	}
	
	@Test
	void dice_should_produce_two_fixed_numbers_from_array_in_roll_after_roll() {
		Dice dice = new Dice();
		int [] fixedArray = {2,4,6,8};
		int [] actualRolls = {0,0,0,0};
		for (int i = 0; i < fixedArray.length; i++) {
			dice.rollInDoubles(fixedArray);
			int result = dice.getLastRoll();
			//have to divide by two because the dice is always going to be double the array input
			actualRolls[i] = result/2;
		}
		Assert.assertArrayEquals(fixedArray, actualRolls);
	}
	
	@Test
	void dice_should_pull_numbers_from_array_in_sequence() {
		Dice dice = new Dice();
		int [] fixedArray = {2,4,6,8,1};
		int [] actualRolls = {0,0,0,0,0};
		
		for (int i = 0; i < fixedArray.length; i++) {
			dice.roll(fixedArray);
			int result = dice.getLastRoll();	
			actualRolls [i] = result;
		}
		int [] expectedArray = {6,14,3,10,9};
		Assert.assertArrayEquals(expectedArray, actualRolls);
	}
	
	
	

}