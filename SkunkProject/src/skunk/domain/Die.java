package skunk.domain;

public class Die
{
	private int lastRoll;
	private DieNumbers numbers; 

	public Die()
	{
		this.numbers = new DieNumbers();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{	
		numbers.fixed(5);
		this.lastRoll = (int) (numbers.getDieNumbers());
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
