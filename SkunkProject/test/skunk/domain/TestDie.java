package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestDie
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
		System.out.println(result);
		assertTrue(result > 0 && result < 7);
	}
	
}

