package skunk.domain;

public class Player {
	private String playerName;
	private Score turnScore; 
	
	public Player(String enteredName){
		this.playerName = enteredName;
		this.turnScore = new Score(); 
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getTurnScore() {
		int score = this.turnScore.getScoreAfterRoll();
		return score;
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Player " + this.getPlayerName() + " --- Score: " + this.getTurnScore();
	}


}
