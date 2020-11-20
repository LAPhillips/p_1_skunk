package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DieTest
{

	@Test
	public void die_should_return_fixed_die_number()
	{
		Die die = new Die();
		die.roll(4);
		int result = die.getLastRoll();
		assertTrue(result == 4);
	}
	
	@Test
	public void die_should_return_random_Number()
	{
		Die die = new Die();
		die.roll();
		int result = die.getLastRoll();
		assertTrue(result > 0 && result < 7);
	}
	
	@Test
	public void die_should_return_array_die_numbers()
	{
		int [] fixedArray = {1,3,5,9};
		int [] actualRolls = {0,0,0,0};
		Die die = new Die();
		for (int i = 0; i < fixedArray.length; i++) {
			die.roll(fixedArray);
			int result = die.getLastRoll();
			actualRolls[i] = result;
		}

		Assert.assertArrayEquals(fixedArray, actualRolls);
	}

	
}

