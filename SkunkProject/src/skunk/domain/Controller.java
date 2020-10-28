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


}
