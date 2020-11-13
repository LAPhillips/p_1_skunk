package skunk.domain;

public class Player {
	private String playerName;
	private Chips chips;
	private int totalTally;

	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = new Chips();
		this.totalTally = 0;
	}

	
	//*************basics***************************************
	public String getPlayerName() {
		return this.playerName;
	}
	
	public int getTally() {
		return this.totalTally;
	}

	//*************chips***************************************

	public int chipsFlow(RollTypes rollType) {
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


	public void updateTally(int turnScore) {
		this.totalTally += turnScore;
	}


	
	





	


}
