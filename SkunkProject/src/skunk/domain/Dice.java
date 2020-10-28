package skunk.domain;
import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;
	private int[] diePair;
	int dieOne;
	int dieTwo;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.diePair = new int[2]; //everyDice has two numbers
	//	this.dieOne = 0;
	//	this.dieTwo = 0;
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	//basic roll is random
	public void roll()
	{
		die1.roll();
		die2.roll();
		diePair[0] = die1.getLastRoll();
		diePair[1] = die2.getLastRoll();
		
		this.lastRoll = diePair[0] + diePair[1];
	}
	
	//overloaded roll with fixed number
	public void roll(int num1, int num2)
	{

		die1.roll(num1);
		die2.roll(num2);
		
		diePair[0] = die1.getLastRoll();
		diePair[1] = die2.getLastRoll();
		
		this.lastRoll = diePair[0] + diePair[1];
	}
	
	//overloaded with numbers from an array 
	public void roll(int [] numbers)
	{
		die1.roll(numbers);
		diePair[0] = die1.getLastRoll();
		die1.roll(numbers);
		diePair[1] = die1.getLastRoll();
	
		this.lastRoll = diePair[0] + diePair[1];
	}
	
	public void rollInDoubles(int[] numbers) {
		die1.roll(numbers);
		die2.roll(numbers);
		
		diePair[0] = die1.getLastRoll();
		diePair[1] = die2.getLastRoll();
		
		this.lastRoll = diePair[0] + diePair[1];
	}
	
	
	

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + dieOne + " + " + dieTwo;
	}



	// static methods can go anywhere - but at end is one convention

//	public static final int NUM_TRIALS = 360;

/*	public static void main(String[] args)
	{
		// simulate repeated rolls of Dice, counting the many double skunks
		
		Dice dice = new Dice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice.roll();
			StdOut.println(dice);

			if (dice.getLastRoll() == 2)
				doubleSkunkCount++;
		}

		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
*/
}
