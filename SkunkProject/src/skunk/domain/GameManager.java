package skunk.domain;

import java.util.ArrayList;

public class GameManager {
	private Player player;
	private Dice dice;
	private Score score;
	private Boolean turnTracker;
	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
		this.score = new Score();
		this.turnTracker = true;
	}

	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.player = newPlayer;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int[] playerRollsDice() {
		dice.roll();
		return dice.getDicePair();
	}

	//overloaded method for fixed dice
	public int[] playerRollsDice(int die1, int die2) {
		dice.roll(die1, die2);
		return dice.getDicePair();
	}
	
	public void recordsTheTurnScore(int[] newScore) {
		score.recordScore(newScore);
	}

	public ArrayList<Integer> sharesTurnScores() {
		return score.getTurnScores();
	}

	public int diceTotalScore() {
		return dice.getLastRoll();
	}

	public Boolean getContinueTurn() {
		return this.turnTracker;
		
	}


}
