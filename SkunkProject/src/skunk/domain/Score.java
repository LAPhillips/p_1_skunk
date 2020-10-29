package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single roll
public class Score {
	private int combinedRoll;
	private Scoreboard playerScoreBoard;
	
	public Score() {
		this.combinedRoll = 0;
		this.playerScoreBoard = new Scoreboard();
	}
	
	//overloading for testing
	public Score(int testingScore) {
		this.combinedRoll = testingScore;
	}

	public int getTotalScoreForRoll() {
		return this.combinedRoll;
	}

	public void setScoreForRoll(int rollAmount) {
		this.combinedRoll = rollAmount;
	}

	public void recordScore(int[] scoreAfterRoll) {
		this.playerScoreBoard.recordRoll(scoreAfterRoll);
	}

	public int getSpecificRecordedScore(int index) {
		return this.playerScoreBoard.getSpecificTurnScores(index);
	}

	public ArrayList<Integer> getTurnScores() {
		return playerScoreBoard.getTurnScores();
	}


}
