package skunk.domain;

public class Die
{
	private int lastRoll;
	private DieNumbers numbers = new DieNumbers(); 

	public Die()
	{ }
	
	public Die(int fixedNumber)
	{
		this.numbers.fixed(fixedNumber);
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{	
		this.lastRoll = (int) (numbers.getDieNumbers());
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
