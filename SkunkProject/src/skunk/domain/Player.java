package skunk.domain;

public class Player {
	private String playerName;
	private TurnScore turnscore; 
	
	public Player(String enteredName){
		this.playerName = enteredName;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getTurnScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
