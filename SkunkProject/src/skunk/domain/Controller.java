package skunk.domain;
//Controller should only report to and from the UI; does not decide things on its own
public class Controller {
	private GameManager manager;
	private GameSetup setup;
	private int numberPlayers;
	
	public Controller() {
		this.manager = new GameManager();
		this.setup = new GameSetup();
		this.numberPlayers = 1;
	}

	//*************Player*************************************************************
	public void sharePlayerName(String name) {
		
		this.manager.assignPlayer(name);
	}
	
	public String getPlayerNameFromManager() {
		return this.manager.playerName();
	}
	
	//to use for testing in JUnit
	public GameManager getManager() {
		return this.manager; 
	}

	public void sharePlayerInputs(char playerInput) {
		manager.setContinueTurn(playerInput);
	}
	
	public int getPlayerChipsFromManager() {
		return this.manager.getChips();
	}
	
	public int getLostChips() {
		return this.manager.getLostChips();
	}
	
	public void setupGame(int enteredAmount) {
		this.setup.setupGame(enteredAmount);;
	}
	
	public int getNumPlayers() {
		return this.setup.getNumPlayers();
	}

	//*************Dice/Rolls********************************************************
	//normal dice
	public int[] shareRoll() {
		manager.checkRollRecord();
		return manager.returnDiceRoll();
	}
	
	//fixed dice
	public int[] shareRoll(int die1, int die2) {
		manager.checkRollRecord(die1, die2);
		return manager.returnDiceRoll();
	}

	public int rollTotal() {
		return manager.diceTotalScore();
	}

	public Boolean startNewRoll() {
		return manager.getTurnStatus();
	}
	
	public RollTypes reportsSpecialRoll() {
		return manager.getRollType();
	}
	
	//*************Scores******************************************************** 

	public int totalTurnScore() {
		return manager.getFinalTurnScore();
	}

	public int reportsSpecificRoll(int rolls) {
		return manager.sharesTurnScores().get(rolls);
	}

	public int numberOfRolls() {
		return manager.numberOfRolls();
	}

	public Player[] getPlayers() {
		return this.setup.getPlayers();
	}

}
