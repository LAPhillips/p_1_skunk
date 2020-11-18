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

	
	//*************basics***************************************
	public String getPlayerName() {
		return this.playerName;
	}

	//*************chips***************************************

	public void updateForSpecial(RollTypes rollType) {
		chips.adjustChipsForRoll(rollType);
		if(rollType == RollTypes.DOUBLE_SKUNK) {
			score.updateForDoubleSkunk();
		}
	}
	
	public int chipsLostPerRollType(RollTypes rollType) {
		return chips.calculateChipChange(rollType);
	}

	public void addChips(int amount) {
		this.chips.addChips(amount);
	}
	
	public void subtractChips(int amount) {
		this.chips.subtractChips(amount);
	}
	
	public int getLostChips() {
		return this.chips.lostChips();
	}
	
	public int getChips() {
		return this.chips.getChips(); //total number of chips currently
	}
	
	//*************Managing Turns*************************************************************
	
	public Boolean getTurnStatus() {
		return turn.getTurnStatus();
	}

	public void endTurn() {
		turn.endTurn();
		score.updateFinalScore();
	}

	public void startTurn() {
		score.startNewTurn();
		turn.startNewTurn();
	}
	
	//*************Managing Score*************************************************************
	
	public void playerGetsDiceRoll(int [] newRoll) {
		score.recordScore(newRoll);
	}
	
	public int getFinalScore() {
		return score.getFinalScore();
	}
	
	public ArrayList<Integer> getScoreboard() {
		return score.getScoreboard();
	}
	
	public int getTotalTurnScore(boolean isSpecial) {
		return score.finalTurnScore(isSpecial);
	}
	
	@Override
	public String toString() {
		return playerName + " \n" + "Final Score: " + getFinalScore() + " \n" + "Chips Count: " + this.getChips();
	}
}
