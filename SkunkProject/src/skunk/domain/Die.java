package skunk.domain;

public class Die
{
	private int lastRoll;

	public Die()
	{
		this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (6);
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
