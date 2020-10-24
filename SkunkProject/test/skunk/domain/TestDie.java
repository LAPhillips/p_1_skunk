package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void dieShouldReturnDieNumber()
	{
		Die die = new Die();
		DieNumbers numbers = new DieNumbers();
		int dieResult = die.getLastRoll();
		int numberResult = numbers.getDieNumebrs();
		assertTrue(dieResult == numberResult);
		}
	}

