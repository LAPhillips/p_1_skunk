package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

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
	void Sequenceddie_should_return_a_one_or_three() {
		DieNumbers numbers = new DieNumbers();
		numbers.sequencedNumbers();
		int result1 = numbers.getDieNumbers();
		numbers.sequencedNumbers();
		int result2 = numbers.getDieNumbers();
		numbers.sequencedNumbers();
		int result3 = numbers.getDieNumbers();
		assertTrue(result1 == 1 && result2 == 3 && result3 == 1);
	}

	
	
	
}
