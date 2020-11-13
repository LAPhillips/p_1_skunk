package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single turn
public class Score {

	private RollTypes rollType;
	private int finalScore;
	private ArrayList<Integer> scoreboard;
	
	public Score() {
		this.rollType = RollTypes.NORMAL; // only ever reports the most recent roll
		this.finalScore = 0;
		this.scoreboard = new ArrayList<>();
	}
	
	//*************Score Flow*************************************************************

	//records & edits score 
	public void recordAndUpdate(int[] scoreAfterRoll) {
		this.recordScore(scoreAfterRoll);
		this.editFinalScore(scoreAfterRoll);
	}

	//*************Recording/Reporting Scores*************************************************************
	public int getTotalScoreForTurn() {
		ArrayList<Integer> turnTotals = this.getScoreboard();
		int scoreTotals = 0;
		for (int scores : turnTotals) {
			scoreTotals += scores;
		}
		return scoreTotals;
	}
	
	public void recordScore(int[] newRoll) {
		scoreboard.add(newRoll[0]);
		scoreboard.add(newRoll[1]);
	}

	public int getSpecificRecordedScore(int index) {
		return scoreboard.get(index);
	}

	public ArrayList<Integer> getScoreboard() {
		return this.scoreboard;
	}
	
	public int getNumRolls() {
		return 0;
	}


//*************Managing Special Rolls*************************************************************

	public Boolean isSpecial(int [] diceRoll) {
		if (diceRoll[0] == 1 || diceRoll[1] == 1) {
			return true;
		}
		else if ((diceRoll[0] == 1 || diceRoll[1] == 1) && (diceRoll[0] == 2 && diceRoll[1] == 1)) {
			return true;
		}
		return false;
	}
	
	public void setRollType(int[] scores) {
		int score1 = scores[0];
		int score2 = scores[1];
		
		if (score1 == 1) {
			if (score2 == 1) {
				this.rollType = RollTypes.DOUBLE_SKUNK; //1,1
			}
			else if (score2 == 2){
				this.rollType = RollTypes.SKUNK_DEUCE; // 1,2
			}
			else {
				this.rollType = RollTypes.SKUNK; // 1,x
			}
		}
		else if (score1 == 2 && score2 == 1) {
				this.rollType = RollTypes.SKUNK_DEUCE; // 2,1
		}
		else if (score2 == 1) {
			this.rollType = RollTypes.SKUNK; // x,1
		}
		else {
			this.rollType = RollTypes.NORMAL;
		}
	}

	public RollTypes getRollType() {
		return this.rollType;
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
		ArrayList<Integer> fullScores = this.scoreboard;
		int totalScore = 0;
		for (int dieRoll : fullScores) {
			totalScore += dieRoll;
		}
		return totalScore;
	}

	

}
