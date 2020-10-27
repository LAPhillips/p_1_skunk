package skunk.domain;

public class Controller {
	private String playerName;
	
	public Controller() {
		this.playerName = "noName";
	}

	public void setsPlayerName(String name) {
		this.playerName = name;
	}

	public String getPlayerName() {
		return this.playerName;
	}

}
