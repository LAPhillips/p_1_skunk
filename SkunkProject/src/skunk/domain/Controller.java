package skunk.domain;

public class Controller {
	private String playerName;
	private GameManager manager;
	
	public Controller() {
		this.playerName = "noName";
		this.manager = new GameManager();
	}

	public void setsPlayerName(String name) {
		this.playerName = name;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int[] shareRoll(int die1, int die2) {
		return manager.playerRollsDice(die1, die2);
	}
}
