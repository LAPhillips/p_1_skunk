package skunk.domain;

public class TurnScore {
	private int roll;
	
	public TurnScore() {
		this.roll = 0;
	}
	
	//overloading for testing
	public TurnScore(int testingScore) {
		this.roll = testingScore;
	}

	public int getScoreAfterRoll() {
		return this.roll;
	}

	public void setScoreForRoll(int rollAmount) {
		this.roll = rollAmount;
	}

}
