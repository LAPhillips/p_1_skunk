package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single turn
public class Score {

	private Scoreboard playerScoreBoard;
	private SpecialRolls special;
	private int finalScore;
	
	public Score() {
		this.playerScoreBoard = new Scoreboard();
		this.special = null; // only ever reports the most recent special roll
		this.finalScore = 0;
	}
	
	//*************Score Flow*************************************************************

	//makes sure it does not record any special rolls
	public void checkThenRecord(int[] scoreAfterRoll) {
		if (this.isSpecial(scoreAfterRoll)) {
		}
		else {
			this.recordScore(scoreAfterRoll);
		}
		this.editFinalScore(scoreAfterRoll);
	}

	//*************Recording/Reporting Scores*************************************************************
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


//*************Managing Special Rolls*************************************************************

	public Boolean isSpecial(int [] diceRoll) {
		if (diceRoll[0] == 1 || diceRoll[1] == 1) {
			return true;
		}
		else if ((diceRoll[0] == 2 || diceRoll[1] == 2) && ((diceRoll[0] == 1 || diceRoll[1] == 1))) {
			return true;
		}
		return false;
}
	
	public void setTypeSpecial(int[] scores) {
		int score1 = scores[0];
		int score2 = scores[1];
		
		if (score1 == 1) {
			if (score2 == 1) {
				this.special = SpecialRolls.DOUBLE_SKUNK; //1,1
			}
			else if (score2 == 2){
				this.special = SpecialRolls.SKUNK_DEUCE; // 1,2
			}
			else {
				this.special = SpecialRolls.SKUNK; // 1,x
			}
		}
		else if (score1 == 2) {
				this.special = SpecialRolls.SKUNK_DEUCE; // 2,1
		}
		else if (score2 == 1) {
			this.special = SpecialRolls.SKUNK; // x,1
		}
	}

	public SpecialRolls getSpecialRollType() {
		return this.special;
	}

	
	
	public int getFinalScore() {
		return this.finalScore;
	}
	
	
	public void setFinalScore(int newFinalScore) {
		this.finalScore = newFinalScore;
	}

	public void editFinalScore(int[] diceRoll) {
		if(this.isSpecial(diceRoll)) {
			this.setFinalScore(0);
		}
		else {
			this.setFinalScore(this.totalScore());
		}

	}

	
	public int totalScore() {
		ArrayList<Integer> fullScores = playerScoreBoard.getTurnScores();
		int totalScore = 0;
		for (int dieRoll : fullScores) {
			totalScore += dieRoll;
		}
		return totalScore;
	}

	



}
