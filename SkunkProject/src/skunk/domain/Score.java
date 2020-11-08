package skunk.domain;

import java.util.ArrayList;

//Score is responsible for moderating the score of a single turn
public class Score {

	private Scoreboard playerScoreBoard;
	private SpecialRolls special;
	
	public Score() {
		this.playerScoreBoard = new Scoreboard();
		this.special = SpecialRolls.DOUBLE_SKUNK;
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

	public Boolean isSpecial(int [] diceRoll) {
			if (diceRoll[0] == 1 || diceRoll[1] == 1) {
				return true;
			}
			else if ((diceRoll[0] == 2 || diceRoll[1] == 2) && ((diceRoll[0] == 1 || diceRoll[1] == 1))) {
				return true;
			}
			return false;
	}

	
	public void checkThenRecord(int[] scores) {
		if (isSpecial(scores)) {
			
		}
		else {
			this.recordScore(scores);
		}
	}

	public void setTypeSpecial(int[] scores) {
		int score1 = scores[0];
		int score2 = scores[1];
		
		if (score1 == 1) {
			if (score2 == 1) {
				this.special = SpecialRolls.DOUBLE_SKUNK;
			}
			
		}

		
	}

	public SpecialRolls getSpecialRollType() {
		return this.special;
	}


}
