package skunk.domain;

public class Player {
	private String playerName;
	private TurnScore turnScore; 
	
	public Player(String enteredName){
		this.playerName = enteredName;
		this.turnScore = new TurnScore(); 
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getTurnScore() {
		int score = this.turnScore.getScoreAfterRoll();
		System.out.println(score);
		return score;
		
	}

}
