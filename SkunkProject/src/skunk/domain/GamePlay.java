package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdIn;

public class GamePlay {
	
	private Player activePlayer;
	private Dice dice;
	private int[] currentRoll;
	private Score score; 
	private Player[] players;
	private int playerTracker; 
	
	public GamePlay() {
		this.activePlayer = new Player("name");
		this.dice = new Dice();
		this.currentRoll = new int[2]; 
		this.score = null; 
		this.players = null;
		this.playerTracker = 0;
	}
	
	
	public void howManyPlayers() {
		System.out.println("How many players? ");
		int numberPlayers = StdIn.readInt();
		this.players = new Player[numberPlayers];
		askNames();
		this.activePlayer = players[playerTracker];
	}
	
	public void askNames() {
		for (int i = 0; i < players.length; i++) {
			System.out.println("What is player " + (i+1) + "'s name?" );
			String name = StdIn.readString();
			Player player = new Player(name);
			players[i] = player;
			this.score = new Score();
		}
	}
	
	public void allPlayersOneTurn() {
		while(this.activePlayer.getTally() < 100){
			severalTurns();
			System.out.println();
			nextPlayer();
		}
	}
	
	public Player nextPlayer() {
		playerTracker++;
		if (playerTracker < players.length) {
			this.activePlayer = players[playerTracker];
		}
		else {
			playerTracker = 0;
			this.activePlayer = players[playerTracker];
		}
		this.activePlayer.startTurn();
		this.score = new Score();
		return this.activePlayer;	
	}

	public void severalTurns() {
		while(activePlayer.getTurnStatus()) {
			this.singleTurn();
		}
		this.finalReadOut();
	}
	
	public void singleTurn() {
		System.out.println(this.activePlayer.getPlayerName() + ", do you want to roll? [Y/N]");
		char playerInputs = StdIn.readString().charAt(0);
		if (rollOrNot(playerInputs)) {
			singleRoll();
		}
		else {
			activePlayer.endTurn();
		}
	}
	
	private void finalReadOut() {
		System.out.println("Your Score:");
		ArrayList<Integer> scores = score.getScoreboard();
		for (int i = 0; i < scores.size(); i+=2) {
			System.out.println("Die 1: " + scores.get(i) + "    Die 2: " + scores.get(i+1));
		}
		score.editFinalScore(currentRoll);
		this.activePlayer.updateTally(score.getFinalScore());
		System.out.println("Total Score: " + this.activePlayer.getTally()); 
		System.out.println("Lost Chips This Turn: " + (activePlayer.getSingleTurnChipsChange()));
		System.out.println("Total Lost Chips" + (activePlayer.getNetLostChips()));
	}
	
	public void singleRoll() {
			System.out.println(this.activePlayer.getPlayerName() + " turn to roll....");
			dice.roll();
			currentRoll = dice.getDicePair();
			score.recordAndUpdate(currentRoll);
			checkSpecial();
			System.out.println("Your roll was " + currentRoll[0] + " " + currentRoll[1]);
	}
	
	public void checkSpecial() {
		if (isSpecial() != RollTypes.NORMAL) {
			System.out.println("sorry, you rolled a " + isSpecial());
			if (isSpecial() == RollTypes.DOUBLE_SKUNK) {
				activePlayer.setTally(0);
			}
			activePlayer.updateChips(isSpecial());
			activePlayer.endTurn();
		}
		else {
		}
	}
	
	public boolean rollOrNot(char playerInput) {
		if(playerInput == 'y' || playerInput == 'Y') {
			return true;
		}
		return false;
	}
	
	public RollTypes isSpecial() {
		if ((currentRoll[0] + currentRoll[1]) == 2) {
			return RollTypes.DOUBLE_SKUNK;
		}
		else if ((currentRoll[0] + currentRoll[1]) == 3) {
			return RollTypes.SKUNK_DEUCE;
		}
		else if (currentRoll[0] == 1 || currentRoll[1] == 1){
			return RollTypes.SKUNK;
		}
		else {
			return RollTypes.NORMAL;
		}
	}
	
	public Player getActivePlayer() {
		return this.activePlayer;
	}
	
	public void setActivePlayer(Player player) {
		this.activePlayer = player;
	}
	
	public Player[] getPlayers() {
		return this.players;
	}
	
	public void setPlayers(Player[] newPlayers) {
		this.players = newPlayers;
	}
	
	public int getPlayerTracker() {
		return this.playerTracker;
	}
	
	public void setPlayerTracker(int number) {
		this.playerTracker = number;
	}

}


	


