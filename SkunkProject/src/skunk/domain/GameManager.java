package skunk.domain;

import java.util.ArrayList;

//Brings everything together
public class GameManager {
	private Player player;
	private Dice dice;
	private Score score;
	private int turn;
	private Boolean turnTracker;
	private int [] currentDiceRoll;

	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
		this.score = new Score();
		this.turnTracker = true;
		this.currentDiceRoll = new int[2];
		this.turn = 0;
	}

	//*************Player*************************************************************
	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.player = newPlayer;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	//*************Dice/Score*************************************************************
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
	
	
	public int numberOfRolls() {
		ArrayList<Integer> turnScores = this.sharesTurnScores();
		return turnScores.size()/2;
	}

	public int totalTurnScore() {
		return score.getTotalScoreForTurn();
	}

	public void checkThenRecord(int[] diceRoll) {
		if (this.isItSpecial(diceRoll)) {
			System.out.println("SKUNK");
		}
		else {
			this.recordsTheTurnScore(diceRoll);
		}
	}
	
	//*************Managing Turns*************************************************************
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

	public void endsTurn() {
		this.turn++;
	}

	public Boolean isItSpecial(int[] DiceRoll) {
		if (DiceRoll[0] == 1 || DiceRoll[1] == 1) {
			return true;
		}
		else if ((DiceRoll[0] == 2 || DiceRoll[1] == 2) && ((DiceRoll[0] == 1 || DiceRoll[1] == 1))) {
			return true;
		}
		return false;
	}



	public void checkRollRecord() {
		if (turnTracker == true) {
			this.playerRollsDice();
			this.checkThenRecord(this.currentDiceRoll);
		}
		else {
			endsTurn();
		}
	}
	
	public void checkRollRecord(int die1, int die2) {
		if (turnTracker == true) {
			this.playerRollsDice(die1, die2);
			this.checkThenRecord(this.currentDiceRoll);
		}
		else {
			endsTurn();
		}
	}

}
