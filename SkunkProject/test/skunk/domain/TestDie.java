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
		numbers.randomOneToSix();
		int dieResult = die.getLastRoll();
		System.out.println(dieResult);
		int numberResult = numbers.getDieNumebrs();
		System.out.println(numberResult);
		assertTrue(dieResult == numberResult);
		}
	}

