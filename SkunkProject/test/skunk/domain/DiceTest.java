package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DiceTest {
	
	@Test
	void dice_should_produce_two_fixed_numbers() {
		Dice dice = new Dice();
		dice.roll(1, 4);
		int result = dice.getLastRoll();
		assertTrue(result == 5);
	}
	
	@Test
	void dice_should_share_dice() {
		Dice dice = new Dice();
		dice.roll(2, 3); //using fixed dice to test
		int[] newRoll = dice.getDicePair();
		assertTrue(newRoll[0] == 2 && newRoll[1] == 3);
	}
	
	@Test
	void dice_should_share_specific_die_when_asked() {
		Dice dice = new Dice();
		dice.roll(2, 3);
		int secondDie = dice.getSpecificDie(1);
		assertEquals(3, secondDie);
	}
	
		@Test
	void dice_should_produce_two_random_numbers() {
		Dice dice = new Dice();
		dice.roll();
		int result = dice.getLastRoll();
		assertTrue(result > 0 && result < 13);
	}

	


}
