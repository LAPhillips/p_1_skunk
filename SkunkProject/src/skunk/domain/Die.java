package skunk.domain;

public class Die
{
	private int lastRoll;
	private DieNumbers numbers; 

	public Die()
	{
		this.roll();
		this.numbers = new DieNumbers();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (this.numbers.getDieNumebrs());
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
