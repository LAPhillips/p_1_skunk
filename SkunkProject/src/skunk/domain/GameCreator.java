package skunk.domain;

public class GameCreator {

	public Object createPlayer(String playerName) {
		Player player = new Player(playerName);
		System.out.println(player);
		return player;
	}

	public String getPlayerName() {
		return "mike";
	}

}
