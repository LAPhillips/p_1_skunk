package skunk.domain;

public class Player {
	private String playerName;
	private int chips;
	private static final int STARTING_CHIPS = 50;
	
	
	public Player(String enteredName){
		this.playerName = enteredName;
		this.chips = 50;
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Player " + this.getPlayerName() + " --- Score: " ;
	}

	public int getChips() {
		return this.chips;
	}

	public void removeChips(int chipsLost) {
		this.chips -= chipsLost;
	}

	public void gainChips(int chipsGained) {
		this.chips += chipsGained;
		
	}

	public int getLostChips() {
		return this.STARTING_CHIPS - this.getChips();
	}


}
