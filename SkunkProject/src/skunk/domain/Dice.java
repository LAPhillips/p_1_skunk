package skunk.domain;
import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * @author eric
 *
 */

public class Dice
{   
	private int lastRollSum;
	private Die die1;
	private Die die2;
	private int[] diePair;

	public Dice(){
		this.die1 = new Die();
		this.die2 = new Die();
		this.diePair = new int[] {0,0}; //every roll has two numbers from the die
		this.lastRollSum = 0;
	}

	public int getLastRoll(){
		return this.lastRollSum;
	}
	
	public int[] getDicePair() {
		return this.diePair;
	}

	//basic roll is random
	public void roll(){
		die1.roll();
		die2.roll();
		diePair[0] = die1.getLastRoll();
		diePair[1] = die2.getLastRoll();
		
		this.lastRollSum = diePair[0] + diePair[1];
	}
	
	//overloaded roll with fixed number
	public void roll(int num1, int num2){
		die1.roll(num1);
		die2.roll(num2);
		
		diePair[0] = die1.getLastRoll();
		diePair[1] = die2.getLastRoll();
		
		this.lastRollSum = diePair[0] + diePair[1];
	}

	public String toString(){
		return "First Die: " + diePair[0] + "   Second Die: " + diePair[1] + "    Roll Total: " + (diePair[0] + diePair[1]);
	}

}
