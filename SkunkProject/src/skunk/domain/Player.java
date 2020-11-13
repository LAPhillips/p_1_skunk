package skunk.domain;

public class Player {
	private String playerName;
	private Chips chips;
	private Score score;
	private RollTypes rollType;

	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = new Chips();
		this.score = new Score();
		this.rollType = RollTypes.NORMAL;
	}

	///player needs to be able to give roll to chips and then chips give back lost; should not have to adjust itself
	public String getPlayerName() {
		return this.playerName;
	}
	

	public int getChips() {
		return this.chips.getNumChips();
	}

	public int getLostChips() {
		return this.chips.amountChange();
	}

	public void givesChipsRollType(RollTypes roll) {
		this.chips.calculateChipChange(roll);
	}
	
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
