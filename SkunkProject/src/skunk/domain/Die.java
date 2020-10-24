package skunk.domain;

public class Die
{
	private int lastRoll;
	private int counter = 0;

	public Die()
	{ 

	}
	
	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	//Default dice is random; This only changes the die, does not deliver the result
	public void roll() 
						
	{	
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}
	
	//Method overloaded with int delivered fixed value; This only changes the die, does not deliver the result
	public void roll(int fixed) 
	{	
		this.lastRoll = (int) (fixed);
	}
	
	//Method overloaded with array delivers the values of the array in order; This only changes the die, does not deliver the result
	public void roll(int [] fixedArray) // note how this changes Die's state, but doesn't return
	// anything
	{	
		if (this.counter >= fixedArray.length) {
			counter = 0;	
			}
			this.lastRoll = fixedArray[counter];
			counter ++;
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
