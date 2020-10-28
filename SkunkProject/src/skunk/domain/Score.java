package skunk.domain;

public class Score {
	private int roll;
	private Scoreboard playerScoreBoard;
	
	public Score() {
		this.roll = 0;
		this.playerScoreBoard = new Scoreboard();
	}
	
	//overloading for testing
	public Score(int testingScore) {
		this.roll = testingScore;
	}

	public int getScoreAfterRoll() {
		return this.roll;
	}

	public void setScoreForRoll(int rollAmount) {
		this.roll = rollAmount;
	}

	public void recordScore(int scoreAfterRoll) {
		this.playerScoreBoard.recordRoll(scoreAfterRoll);
	}

	public int getSpecificRecordedScore(int index) {
		return this.playerScoreBoard.getSpecificTurnScores(index);
	}


}
