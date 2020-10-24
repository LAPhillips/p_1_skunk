package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DieNumbersTest {

	@Test
	void die_should_return_number_between_one_and_six() {
		int result = DieNumbers.randomOneToSix();
		assertTrue(result < 7 && result > 0);
	}
}
