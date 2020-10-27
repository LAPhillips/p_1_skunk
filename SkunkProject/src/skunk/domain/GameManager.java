package skunk.domain;

public class GameManager {
	private Player player;
	private Dice dice;
	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
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
		return 5;
	}

}
