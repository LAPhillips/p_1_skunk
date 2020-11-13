package skunk.domain;

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

	///player needs to be able to give roll to chips and then chips give back lost; should not have to adjust itself
	
	//player gives roll type to chips
	//chips calculates change
	//player gets change (int) from chips
	
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setCurrentRoll(int[] roll) {
		this.currentRoll = roll;
	}
	
	public int[] getCurrentRoll() {
		return this.currentRoll;
	}


	//*************chips***************************************

	public int chipsFlow(RollTypes roll) {
		this.givesChipsRollType(roll);
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
	
	//*************chips***************************************
	
	public int getIndividualScore() {
		return score.getTotalScoreForTurn();
	}

	public void recordScore(int[] newScore) {
		this.score.recordAndUpdate(newScore);
	}

	public RollTypes getRollType() {
		return this.rollType;
	}

	public void updateRollType(RollTypes type) {
		this.rollType = type;
		
	}


	


}
