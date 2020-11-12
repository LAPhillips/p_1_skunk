package skunk.domain;

public class Player {
	private String playerName;
	private Chips chips;
//	private int chips;
	private int chipsAtStartOfTurn;
	

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
		return this.chipsAtStartOfTurn - this.getChips();
	}

	public void setChips(int startingChips) {
		this.chipsAtStartOfTurn = startingChips;
	}

}
