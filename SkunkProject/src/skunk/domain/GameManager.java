package skunk.domain;

public class GameManager {
	private Player[] players;
	private TurnManager turnManager;
	private int numPlayers;
	
	public GameManager() {
		this.players = null;
		this.turnManager = new TurnManager();
		this.numPlayers = 1;
	}

	public void setupGame(int numberPlayers) {
		this.numPlayers = numberPlayers;
		this.players = new Player[numberPlayers];
	}
	
	public void createPlayer(String playerName) {
		Player player = new Player(playerName);
		this.addPlayer(player);
	}
	
	public Player[] getPlayers() {
		return this.players;
	}


	public Player getSinglePlayer(int index) {
		return this.players[index];
	}

	public void addPlayer(Player player) { //adds player to next open slot
		int size = this.players.length;
		for (int i = 0; i < size; i++) { 
			if (this.players[i] != null) {
				continue;
			}
			else if (this.players[i] == null) {
				this.players[i] = player;
				break;
			}
		}
	}
	



	public int getNumPlayers() {
		return this.numPlayers;
	}

	public void changeTurnStatus() {
		for (int i = 0; i < this.players.length; i++) {
			Player player = this.players[i];
			if (player.getTurnStatus()) {
				player.endTurn();
			}
			else {
				player.startTurn();
			}
		}
		
	}

	public Player getPlayerFromManager() {
		return null;
	}

	public TurnManager getTurnManager() {
		return this.turnManager;
	}
	

	

	

}
