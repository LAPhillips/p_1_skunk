package skunk.domain;

import java.util.ArrayList;

public class Player {
	private String playerName;
	private Chips chips;
	private Score score;
	private Turn turn;

	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = new Chips();
		this.turn = new Turn();
		this.score = new Score();
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	public int getLostChips() {
		return this.chips.lostChips();
	}
	
	public int getChips() {
		return this.chips.getChips(); //total number of chips currently
	}
	
	public boolean getTurnStatus() {
		return turn.getTurnStatus();
	}
	
	public boolean getFinalTurn() {
		return turn.getFinalTurn();
	}
	
	public int getFinalScore() {
		return score.getFinalScore();
	}
	
	public int getTurnScore() {
		return score.getTurnScore();
	}
	
	public ArrayList<Integer> getScoreboard() {
		return score.getScoreboard();
	}
	

	//*************chips***************************************

	public int chipsLostPerRollType(RollTypes rollType) {
		return chips.calculateChipChange(rollType);
	}
	
	public void addChips(int amount) {
		this.chips.addChips(amount);
	}
	
	public void subtractChips(int amount) {
		this.chips.subtractChips(amount);
	}

	public void updateForSpecial(RollTypes rollType) {
		chips.adjustChipsForRoll(rollType);
		if(rollType == RollTypes.DOUBLE_SKUNK) {
			score.updateForDoubleSkunk();
		}
	}
	
	//*************Managing Turns*************************************************************

	public void endTurn() {
		score.updateFinalScore();
		turn.endTurn();
	}

	public void startTurn() {
		score.startNewTurn();
		turn.startNewTurn();
	}
	
	public void checkForFinalTurn() {
		if (score.getFinalScore() >= 100) {
			updateFinalTurn();
		}
	}
	
	public void updateFinalTurn() {
		turn.updateFinalTurn();
	}
	
	//*************Managing Score*************************************************************
	
	public void playerGetsDiceRoll(int [] newRoll) {
		score.recordScore(newRoll);
	}
	
	public void updateTurnStatusAndScore(int[] currentRoll, boolean isSpecial) {
		score.updateTurnScore(currentRoll, isSpecial);
		if(isSpecial) {
			endTurn();
		}
	}
	
	@Override 
	public String toString() {
		return playerName + "\n" + "--------- Final Score: " + getFinalScore() + "\n" +  "--------- Chips Count: " + this.getChips();
	}
}
