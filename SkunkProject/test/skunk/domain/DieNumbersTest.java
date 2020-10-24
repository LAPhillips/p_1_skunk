package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DieNumbersTest {
	
	@Test
	void Fixeddie_should_return_a_specific_number() {
		DieNumbers numbers = new DieNumbers();
		numbers.fixed();
		int result = numbers.getDieNumebrs();
		System.out.println("first" + result);
		assertTrue(result == 7);
	}

	@Test
	void randomdie_should_return_number_between_one_and_six() {
		DieNumbers numbers = new DieNumbers();
		numbers.randomOneToSix();
		int result = numbers.getDieNumebrs();
		System.out.println("second" + result);
		assertTrue(result < 7 && result > 0);
	}
}
