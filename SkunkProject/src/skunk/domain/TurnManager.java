package skunk.domain;

import java.util.ArrayList;

//Brings everything together -- manages the game 
public class TurnManager {
	private Player activePlayer;
	private Dice dice;
	private Score score;
	private int [] currentDiceRoll;
	private int numPlayers;

	public TurnManager() {
		this.activePlayer = null;
		this.dice = new Dice();
		this.score = new Score(); //start new score for each player?
		this.currentDiceRoll = new int[] {0,0};
		this.numPlayers = 1;
	}

	//*************setting up game*************************************************************	
	
	public void assignPlayer(String playerName) {
		Player newPlayer = new Player(playerName);
		this.activePlayer = newPlayer;
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
	
	//*************Regulating Turn Flow*************************************************************
	public void checkRollRecord() {
		if (this.activePlayer.getTurnStatus()) { //checks to make sure turn status is not false
			this.playerRollsDice();// player rolls dice
			this.recordsTheTurnScore(this.currentDiceRoll);
			this.updatesForSpecialRolls();
		}
		else {
		}
	}
	
	public void checkRollRecord(int die1, int die2) {
		if (this.activePlayer.getTurnStatus()) {  //checks to make sure turn status is not false
			this.playerRollsDice(die1, die2);    // player rolls dice
			this.recordsTheTurnScore(this.currentDiceRoll);
			this.updatesForSpecialRolls();
		}
		else {
		}
	}

	//*************Player*************************************************************
	
	public int getPlayerTally() {
		return this.activePlayer.getTally();
	}

	public Boolean getTurnStatus() {
		return this.activePlayer.getTurnStatus();
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
		return this.score.getNumRolls();
	}
	
	public RollTypes getRollType() {
		score.setRollType(currentDiceRoll);
		return this.score.getRollType();
	}

	//*************Managing Turns*************************************************************

	public void setContinueTurn(char playerInput) {
		if (playerInput == 'Y' || playerInput == 'y') {
		}
		else {
			this.endTurn();
		}
	}
	
	public void updatesForSpecialRolls() {
		if (score.isSpecial(currentDiceRoll)) {
			this.endTurn();
			this.shareFinalScore(this.getFinalTurnScore());
		}
		else {
			
		}
	}
	
	public void endTurn() {
		this.activePlayer.endTurn();
		this.shareFinalScore(this.getFinalTurnScore());
	}

	//*************Keeping Score*************************************************************
	public int getChips() {
		return activePlayer.getChips();
	}

	public int getLostChips() {
		RollTypes roll = this.getRollType();
		return (-1*activePlayer.chipsFlow(roll)); //update score so that it comes out positive in UI
	}

	public void recordsTheTurnScore(int[] newScore) {
		this.score.recordAndUpdate(newScore);

	}

	public ArrayList<Integer> sharesTurnScores() {
		return this.score.getScoreboard();
	}

	public int diceTotalScore() {
		return dice.getLastRoll();
	}

	public int getFinalTurnScore() {
		return this.score.getFinalScore();
	}

	public void shareFinalScore(int finalScore) {
		this.activePlayer.updateTally(finalScore);
	}

}
