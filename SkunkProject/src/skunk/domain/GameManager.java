package skunk.domain;

import java.util.ArrayList;

//Brings everything together
public class GameManager {
	private Player player;
	private Dice dice;
	private Score score;
	private Turn turn;
	private int [] currentDiceRoll;


	
	public GameManager() {
		this.player = null;
		this.dice = new Dice();
		this.score = new Score();
		this.turn = new Turn();
		this.currentDiceRoll = new int[2];

	}

	//*************Regulating Turn Mechanics*************************************************************
	public void checkRollRecord() {
		if (this.turn.getTurnStatus()) { //checks to make sure turn status is not false
			this.playerRollsDice();      // player rolls dice
			this.checkSpecialStatus();   //checks to make sure the dice are not special
			if(this.turn.getTurnStatus()) {
				this.recordsTheTurnScore(this.currentDiceRoll);
			}
			else {
			}
		
		}
		else {
		}
	}
	
	public void checkRollRecord(int die1, int die2) {
		if (this.turn.getTurnStatus()) {  //checks to make sure turn status is not false
			this.playerRollsDice(die1, die2);      // player rolls dice
			this.checkSpecialStatus();   //checks to make sure the dice are not special
			if(this.turn.getTurnStatus()) {
			this.recordsTheTurnScore(this.currentDiceRoll);
			}
			else {
			}
		
		}
		else {
		}
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
		score.checkThenRecord(newScore);
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
	
	//*************Managing Turns*************************************************************
	public Boolean getContinueTurn() {
		return this.turn.getTurnStatus();
	}

	public void setContinueTurn(char playerInput) {
		this.turn.playersDecision(playerInput);
	}

	public void checkSpecialStatus() {
		if (score.isSpecial(currentDiceRoll)) {
			turn.endTurn();
		}
		else {
			
		}
	}
	

	public SpecialRolls getRollType() {
		score.setTypeSpecial(currentDiceRoll);
		return this.score.getSpecialRollType();
	}

}
