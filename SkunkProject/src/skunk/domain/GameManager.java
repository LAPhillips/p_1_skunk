package skunk.domain;

import java.util.ArrayList;

//Brings everything together -- manages the game 
public class GameManager {
	private Player activePlayer;
	private Dice dice;
	private Score score;
	private Turn turn;
	private int [] currentDiceRoll;
	private RollTypes types;
	private int numPlayers;

	public GameManager() {
		this.activePlayer = null;
		this.dice = new Dice();
		this.score = new Score();
		this.turn = new Turn();
		this.currentDiceRoll = new int[2];
		this.types = RollTypes.NORMAL;
		this.numPlayers = 1;

	}

	//*************Regulating Turn Flow*************************************************************
	public void checkRollRecord() {
		if (this.turn.getTurnStatus()) { //checks to make sure turn status is not false
			this.playerRollsDice();// player rolls dice
			this.recordsTheTurnScore(this.currentDiceRoll);
			this.updatesForSpecialRolls();
		}
		else {
		}
	}
	
	public void checkRollRecord(int die1, int die2) {
		if (this.turn.getTurnStatus()) {  //checks to make sure turn status is not false
			this.playerRollsDice(die1, die2);    // player rolls dice
			this.recordsTheTurnScore(this.currentDiceRoll);
			this.updatesForSpecialRolls();
		}
		else {
		}
	}

	//*************Player*************************************************************
	public void createPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.activePlayer = newPlayer;
	}
	
	public Player getPlayer() {
		return this.activePlayer;
	}
	
	public String playerName() {
		return activePlayer.getPlayerName();
	}
	
	public int getNumPlayers() {
		return this.numPlayers;
	}
	
	public void giveNumPlayers(int enteredAmount) {
		this.numPlayers = enteredAmount;
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

	public int numberOfRolls() {
		ArrayList<Integer> turnScores = this.sharesTurnScores();
		return turnScores.size()/2;
	}

	//*************Managing Turns*************************************************************
	public Boolean getContinueTurn() {
		return this.turn.getTurnStatus();
	}

	public void setContinueTurn(char playerInput) {
		this.turn.playersDecision(playerInput);
	}

	//*************Managing Special Rolls*************************************************************
	public void updatesForSpecialRolls() {
		if (score.isSpecial(currentDiceRoll)) {
	//		this.adjustChipsForRollType();
			this.turn.endTurn();
		}
		else {
			
		}
	}
	
	public RollTypes getRollType() {
		score.setTypeSpecial(currentDiceRoll);
		return this.score.getSpecialRollType();
	}

	//*************Keeping Score*************************************************************
	public int getChips() {
		return activePlayer.getChips();
	}

	public int getLostChips() {
		return activePlayer.getLostChips();
	}

	public void tellsPlayerToAdjustChips(RollTypes roll) {
		this.activePlayer.chipsCalculatesLostGained(roll);
	}
	

	public void recordsTheTurnScore(int[] newScore) {
		score.recordAndUpdate(newScore);
	}

	public ArrayList<Integer> sharesTurnScores() {
		return score.getTurnScores();
	}

	public int diceTotalScore() {
		return dice.getLastRoll();
	}

	public int totalTurnScore() {
		return score.getFinalScore();
	}
	
}
