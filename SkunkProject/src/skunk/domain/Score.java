package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single turn
public class Score {

	private Scoreboard playerScoreBoard;
	
	public Score() {
		this.playerScoreBoard = new Scoreboard();
	}
	

	public int getTotalScoreForRoll() {
		int[] lastTwo = this.getLastTwoRecorded();
		int combinedRoll = lastTwo[0] + lastTwo[1];
		return combinedRoll;
	}

	
	public int getTotalScoreForTurn() {
		ArrayList<Integer> turnTotals = this.getTurnScores();
		int scoreTotals = 0;
		for (int scores : turnTotals) {
			scoreTotals += scores;
		}
		return scoreTotals;
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


	public int[] getLastTwoRecorded() {
		int [] lastTwo = new int[2];
		int scoreArraySize = this.getTurnScores().size();
		lastTwo[0] = this.getSpecificRecordedScore(scoreArraySize-2);
		lastTwo[1] = this.getSpecificRecordedScore(scoreArraySize-1);
		return lastTwo;
	}


}
