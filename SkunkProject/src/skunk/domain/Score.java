package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single player
public class Score {

	
	private int finalScore;
	private int turnScore;
	private ArrayList<Integer> scoreboard;
	
	public Score() {
		this.finalScore = 0;
		this.turnScore = 0;
		this.scoreboard = new ArrayList<>();
	}
	
	//*************Score Flow*************************************************************

	public void recordScore(int[] newRoll) {
		scoreboard.add(newRoll[0]);
		scoreboard.add(newRoll[1]);
	}

	public int turnScore() {
		ArrayList<Integer> fullScores = this.scoreboard;
		int score = 0;
		for (int dieRoll : fullScores) {
			score += dieRoll;
		}
		return score;
	}

	public void startNewTurn() {
		this.scoreboard = new ArrayList<>();
	}
	
	public void updateForDoubleSkunk() {
		finalScore = 0;
	}
	
	public void updateFinalScore() {
		this.finalScore += turnScore;
	}
	
	//*************Getters and Setters*************************************************************
	public ArrayList<Integer> getScoreboard() {
		return this.scoreboard;
	}
	
	public int getFinalScore() {
		return this.finalScore;
	}
	
	public int finalTurnScore(boolean isSpecial) {
		if (isSpecial) {
			this.turnScore = 0;
		}
		else {
			this.turnScore = turnScore();
		}
		return this.turnScore;
	}

}
