package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void die_should_return_fixed_die_number()
	{
		Die die = new Die(4);
		die.roll();
		int result = die.getLastRoll();
		assertTrue(result == 4);
	}
	
	@Test
	public void die_should_return_random_die_number()
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
		Die die = new Die(fixedArray);
		die.roll();
		int result = die.getLastRoll();
		System.out.println(result);
		assertTrue(result == 1);
	}
}

