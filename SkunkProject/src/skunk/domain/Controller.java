package skunk.domain;

public class Controller {
	private String playerName;
	private char playerControls;
	private GameManager manager;
	
	public Controller() {
		this.playerName = "noName";
		this.playerControls = 'Y';
		this.manager = new GameManager();
	}

	public void setsPlayerName(String name) {
		this.playerName = name;
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	//normal dice
	public int[] shareRoll() {
		return manager.playerRollsDice();
	}

	//fixed dice
	public int[] shareRoll(int die1, int die2) {
		return manager.playerRollsDice(die1, die2);
	}

	public int rollTotal() {
		return manager.diceTotalScore();
	}

	public char getsPlayerDecision() {
		return this.playerControls;
	}
	
}
