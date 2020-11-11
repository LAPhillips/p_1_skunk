package skunk.domain;

public class Player {
	private String playerName;
	private int chips;
	private int chipsAtStartOfTurn;
	

	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = 50;
		this.chipsAtStartOfTurn = 50;
	}

	public String getPlayerName() {
		return this.playerName;
	}
	

	public int getChips() {
		return this.chips;
	}
	
	public void adjustChips(int chipChange) {
		this.chips += chipChange;
	}

	public int getLostChips() {
		return this.chipsAtStartOfTurn - this.getChips();
	}

	public void setChips(int startingChips) {
		this.chipsAtStartOfTurn = startingChips;
	}

}
