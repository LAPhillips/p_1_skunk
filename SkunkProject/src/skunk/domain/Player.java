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
	
	public void updateTally(int turnScore) {
		this.totalTally += turnScore;
	}

	//*************chips***************************************

	public void updateChipsForRoll(RollTypes rollType) {
		this.chips.adjustChipsForRoll(rollType);
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
		return this.turn.getTurnStatus();
	}

	public void endTurn() {
		this.turn.endTurn();
	}

	public void startTurn() {
		this.turn.startNewTurn();
	}
	
	public void setTally(int setScore) {
		this.totalTally = setScore;
	}
	
	@Override
	public String toString() {
		return playerName + " \n" + "Final Score: " + this.getTally() + " \n" + "Chips Count: " + this.getChips();
	}
	
	
	
}
