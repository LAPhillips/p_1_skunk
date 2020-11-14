package skunk.domain;

public class GameSetup {
	private Player[] players;
	
	public GameSetup() {
		this.players = null;
	}

	public void createPlayer(String string) {
		
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public void createPlayersInGame(int numberOfPlayers) {
		this.players = new Player[numberOfPlayers];
	}
	
	

}
