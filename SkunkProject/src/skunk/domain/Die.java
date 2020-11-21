package skunk.domain;

public class Die
{
	private int lastRoll;

	public Die() {
		this.lastRoll = 0;
	}

	public int getLastRoll(){
		return this.lastRoll;
	}

	//Default dice is random
	public void roll(){
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	//Method overloaded with int delivered fixed value
	public void roll(int fixed){
		this.lastRoll = (int) (fixed);
	}
	
}
