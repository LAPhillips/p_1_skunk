package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void dieShouldReturnDieNumber()
	{
		Die die = new Die();
		die.roll();
		int result = die.getLastRoll();
		assertTrue(result == 5);
	}
}

