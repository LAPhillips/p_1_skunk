package skunk.domain;

public class Player {
	private String playerName;
	private Chips chips;
	

	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = new Chips();
	}

	public String getPlayerName() {
		return this.playerName;
	}
	

	public int getChips() {
		return this.chips.getNumChips();
	}
	
	public void adjustChips(int chipChange) {
		this.chips.adjustChips(chipChange);
	}

	public int getLostChips() {
		return this.chips.amountChange();
	}

	public void chipsCalculatesLostGained(RollTypes roll) {
		this.chips.calculateChipChange(roll);
	}
	
//	public void setChips(int startingChips) {
//		this.chipsAtStartOfTurn = startingChips;
//	}


}
