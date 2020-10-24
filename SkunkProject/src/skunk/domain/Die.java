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

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{	
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}
	
	public void roll(int fixed) // note how this changes Die's state, but doesn't return
	// anything
	{	
		this.lastRoll = (int) (fixed);
	}
	
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
