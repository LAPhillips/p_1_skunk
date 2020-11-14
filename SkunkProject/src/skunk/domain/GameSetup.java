package skunk.domain;

public class GameSetup {
	private Player[] players;
	
	public GameSetup() {
		this.players = null;
	}

	public void createPlayer(String playerName) {
		
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
	
	

}
