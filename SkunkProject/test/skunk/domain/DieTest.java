package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DieTest
{

	@Test
	public void dice_shares_lastRoll() {
		Die die = new Die();
		int lastRoll = die.getLastRoll();
		assertEquals(0, lastRoll); //lastRoll default should be 0
	}
	
	@Test
	public void random_die_should_return_random_Number()
	{
		Die die = new Die();
		die.roll();
		int result = die.getLastRoll();
		assertTrue(result > 0 && result < 7);
	}
	
	@Test
	public void fixed_die_should_return_fixed_die_number()
	{
		Die die = new Die();
		die.roll(4);
		int result = die.getLastRoll();
		assertTrue(result == 4);
	}

}

