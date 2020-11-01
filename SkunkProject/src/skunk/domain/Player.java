package skunk.domain;

public class Player {
	private String playerName;
	private Score turnScore; 
	
	public Player(String enteredName){
		this.playerName = enteredName;
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Player " + this.getPlayerName() + " --- Score: " ;
	}


}
