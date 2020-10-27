package skunk.domain;

public class GameManager {
	private Player player;
	
	public GameManager() {
		this.player = null;
	}

	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		System.out.println(player);
		this.player = newPlayer;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public void playerRollsDice() {
		// TODO Auto-generated method stub
		
	}

}
