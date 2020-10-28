package skunk.domain;

public class GameManager {
	private Player player;
	private Dice dice;
	private Score score;
	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
		this.score = null;
	}

	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.player = newPlayer;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int playerRollsDice() {
		dice.roll();
		return dice.getLastRoll();
	}

	public int playerRollsFixedDice() {
		dice.roll(2,3);
		return dice.getLastRoll();
	}
	
	

	
	
//	public void recordsTheTurnScore() {
//	}

}
