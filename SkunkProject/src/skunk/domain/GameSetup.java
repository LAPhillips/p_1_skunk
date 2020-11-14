package skunk.domain;

public class GameSetup {
	private Player[] players;
	private int NumPlayers;
	
	public GameSetup() {
		this.players = null;
		this.NumPlayers = 1;
	}

	public void createPlayer(String playerName) {
		Player player = new Player(playerName);
		this.addPlayer(player);
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public void createPlayersInGame(int numberOfPlayers) {
		this.players = new Player[numberOfPlayers];
	}

	public Player getSinglePlayer(int index) {
		return this.players[index];
	}

	public void addPlayer(Player player) { //adds player to next open slot
		int size = players.length;
		for (int i = 0; i < size; i++) { 
			if (players[i] != null) {
				continue;
			}
			else if (players[i] == null) {
				players[i] = player;
				break;
			}
		}
	}
	

	public void setNumberOfPlayers(int numberPlayers) {
		this.NumPlayers = numberPlayers;
		
	}

	public int getNumPlayers() {
		return this.NumPlayers;
	}
	
	

}
