package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DieNumbersTest {
	
	@Test
	void fixedDie_should_return_a_specific_number() {
		DieNumbers numbers = new DieNumbers();
		numbers.fixed(7);
		int result = numbers.getDieNumbers();
		assertTrue(result == 7);
	}

	@Test
	void randomDie_should_return_number_between_one_and_six() {
		DieNumbers numbers = new DieNumbers();
		numbers.randomOneToSix();
		int result = numbers.getDieNumbers();
		assertTrue(result < 7 && result > 0);
	}
	
	@Test
	void enteredArrayDie_should_return_numbers_from_array() {
		DieNumbers numbers = new DieNumbers();
		int [] expecteds = {1,2,3,4};
		int [] actuals = {0,0,0,0};
		for(int i = 0; i < expecteds.length; i++) {
			numbers.enteredArray(expecteds);
			int result = numbers.getDieNumbers();
			actuals[i] = result;
		}
		Assert.assertArrayEquals(expecteds, actuals);
	}
}
