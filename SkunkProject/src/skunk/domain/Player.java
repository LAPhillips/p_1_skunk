package skunk.domain;

public class Player {
	private String playerName;
	private Chips chips;
	private Score score;
	private int totalTally;
	private Turn turn;


	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = new Chips();
		this.totalTally = 0;
		this.turn = new Turn();
		this.score = new Score();
	}

	
	//*************basics***************************************
	public String getPlayerName() {
		return this.playerName;
	}
	
	public int getTally() {
		return this.totalTally;
	}
	
	public int getChips() {
		return this.chips.getNumChips(); //total number of chips currently
	}

	public int getNetLostChips() {
		return this.getNetLostChips();
	}
	
	public int getSingleTurnChipsChange() {
		return this.chips.amountChange();
	}

	//*************chips***************************************

	public void updateChips(RollTypes rollType) {
		this.chips.adjustNetChips(rollType);
	}

	public void updateTally(int turnScore) {
		this.totalTally += turnScore;
	}
	
	public void setTally(int setScore) {
		this.totalTally = setScore;
	}


	//*************Managing Turns*************************************************************
	
	public Boolean getTurnStatus() {
		return this.turn.getTurnStatus();
	}

	public void endTurn() {
		this.turn.endTurn();
	}

	public void startTurn() {
		this.turn.startNewTurn();
	}
	
	@Override
	public String toString() {
		return playerName + "'s current Total Score is " + this.getTally();
	}
	
	
	
}
