package skunk.domain;
//Controller should only report to and from the UI; does not decide things on its own
public class Controller {
	private GameManager gameManage;
	private TurnManager turnManage;
	
	public Controller() {
		this.gameManage = new GameManager();
		this.turnManage = gameManage.getTurnManager();
	}

	//*************Player*************************************************************
	public void sharePlayerName(String name) {
		this.gameManage.createPlayer(name);
	}
	
	public String getPlayerNameFromManager() {
		return this.turnManage.playerName();
	}
	
	//to use for testing in JUnit
	public TurnManager getManager() {
		return this.turnManage; 
	}

	public void sharePlayerInputs(char playerInput) {
		turnManage.setContinueTurn(playerInput);
	}
	
	public int getPlayerChipsFromManager() {
		return this.turnManage.getChips();
	}
	
	public int getLostChips() {
		return this.turnManage.getLostChips();
	}
	
	public void setupGame(int enteredAmount) {
		this.gameManage.setupGame(enteredAmount);;
	}
	
	public int getNumPlayers() {
		return this.gameManage.getNumPlayers();
	}

	//*************Dice/Rolls********************************************************
	//normal dice
	public int[] shareRoll() {
		turnManage.checkRollRecord();
		return turnManage.returnDiceRoll();
	}
	
	//fixed dice
	public int[] shareRoll(int die1, int die2) {
		turnManage.checkRollRecord(die1, die2);
		return turnManage.returnDiceRoll();
	}

	public int rollTotal() {
		return turnManage.diceTotalScore();
	}

	public Boolean startNewRoll() {
		return turnManage.getTurnStatus();
	}
	
	public RollTypes reportsSpecialRoll() {
		return turnManage.getRollType();
	}
	
	//*************Scores******************************************************** 

	public int totalTurnScore() {
		return turnManage.getFinalTurnScore();
	}

	public int reportsSpecificRoll(int rolls) {
		return turnManage.sharesTurnScores().get(rolls);
	}

	public int numberOfRolls() {
		return turnManage.numberOfRolls();
	}

	public Player[] getPlayers() {
		return this.gameManage.getPlayers();
	}

}
