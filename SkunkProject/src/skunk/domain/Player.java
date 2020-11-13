package skunk.domain;

import java.util.ArrayList;

public class Player {
	private String playerName;
	private int[] currentRoll;
	private Chips chips;
	private Score score;
	private RollTypes rollType;

	public Player(String enteredName){
		this.playerName = enteredName;
		this.currentRoll = null;
		this.chips = new Chips();
		this.score = new Score();
		this.rollType = RollTypes.NORMAL;
	}

	
	//*************basics***************************************
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setCurrentRoll(int[] roll) {
		this.currentRoll = roll;
	}
	
	public int[] getCurrentRoll() {
		return this.currentRoll;
	}
	
	public void setRollType(RollTypes type) {
		this.rollType = type;
	}
	public RollTypes getRollType() {
		return this.rollType;
	}

	//*************chips***************************************

	public int chipsFlow(int[] currentRoll) {
		RollTypes rollType = this.getRollTypeFromScore(currentRoll);
		this.givesChipsRollType(rollType);
		return this.chips.amountChange();
	}
	
	public int getChips() {
		return this.chips.getNumChips(); //total number of chips currently
	}

	public int getLostChips() {
		return this.chips.amountChange(); //amount of chips changed per turn
	}

	public void givesChipsRollType(RollTypes roll) {
		this.chips.calculateChipChange(roll); //player gives roll type to chips
	}
	
	//*************Score***************************************
	
	public int getIndividualScore() {
		return score.getTotalScoreForTurn();
	}

	public void recordScore(int[] newScore) {
		this.score.recordAndUpdate(newScore);
	}

	public RollTypes getRollTypeFromScore(int[] roll) {
		this.score.setTypeSpecial(roll);
		return this.score.getSpecialRollType();
	}


	public ArrayList<Integer> getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}






	


}
