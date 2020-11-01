package skunk.domain;

import java.util.ArrayList;

public class GameManager {
	private Player player;
	private Dice dice;
	private Score score;
	private Boolean turnTracker;
	private int [] currentDiceRoll;
	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
		this.score = new Score();
		this.turnTracker = true;
		this.currentDiceRoll = new int[2];
	}

	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.player = newPlayer;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	

	public void playerRollsDice() {
		dice.roll();
		this.currentDiceRoll = dice.getDicePair();
	}

	//overloaded method for fixed dice
	public void playerRollsDice(int die1, int die2) {
		dice.roll(die1, die2);
		this.currentDiceRoll = dice.getDicePair();
	}
	
	public int[] returnDiceRoll() {
		return this.currentDiceRoll;
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

	public void setContinueTurn(char playerDecision) {
		if (playerDecision == 'Y' || playerDecision == 'y') {
			this.turnTracker = true;
		}
		else {
			this.turnTracker = false;
		}
	}

	public void rollsAfterChecking() {
		if (turnTracker == true) {
			this.playerRollsDice();
		}
	}
	
	public void rollsAfterChecking(int die1, int die2) {
		if (turnTracker == true) {
			this.playerRollsDice(die1, die2);
		}
	}



}
