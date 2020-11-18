package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdIn;

public class GamePlay {
	
	private Player activePlayer;
	private Dice dice;
	private int[] currentRoll;
	private RollAdvisor advisor;
	private Player[] players;
	private int playerTracker; 
	private int finalTracker;
	private boolean playerDecision;
	
	public GamePlay() {
		this.activePlayer = new Player(" ");
		this.dice = new Dice();
		this.currentRoll = new int[2]; 
		this.advisor = new RollAdvisor();
		this.players = null;
		this.playerTracker = 0;
		this.finalTracker = 0;
		this.playerDecision = true;
	}
	
	public void createPlayers(int numberPlayers) {
		this.players = new Player[numberPlayers];
	}
	
	public void createPlayer(String name) {
		Player player = new Player(name);
		addPlayer(player);
	}
	
	public void addPlayer(Player player) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
				players[i] = player; 
				break;
			}
		}
		this.activePlayer = players[0];
	}
	
	/*
	public void fullGame() {
		while(this.activePlayer.getFinalScore()< 25){
			singleTurn();
			System.out.println();
			if(this.activePlayer.getFinalScore() >= 25) {
				this.finalTracker = this.playerTracker;
				break;
			}
			nextPlayer();
		}
		finalRound();
	}
	
	public void finalRound() {
		System.out.println(this.activePlayer.getPlayerName() + " scored 100 points or more. Now everyone else gets once more chance to roll");
		for (int i = finalTracker; i < players.length+finalTracker-1; i++) {
			nextPlayer();
			singleTurn();
		}
		finalScore();
	}
	
	public void finalScore() {
		System.out.println();
		winner();
		System.out.println(" FINAL SCORES");
		System.out.println("--------------------");
		for (Player player : players) {
			System.out.println(player.toString());
			System.out.println();
		}
	}
	
	public Player highestScore() {
		Player winner = new Player("winner");
		
		for (Player player : players) {
			if (winner.getFinalScore() < player.getFinalScore()) {
				winner = player;
			}
		}
		return winner;
	}
	
	public void winner() {
		this.activePlayer = highestScore();
		System.out.println(this.activePlayer.getPlayerName() + " wins the round!");
		System.out.println();
		subtractFinalChips();
		giveWinnerChips();
	}
	
	
	public void subtractFinalChips() {
		for (Player player : players) {
			if (player.getFinalScore() == 0) {
				player.subtractChips(10);
			}
			else {
				player.subtractChips(5);
			}
		}
	}
	
	public void giveWinnerChips() {
		int kitty = 0;
		for (Player player: players) {
			kitty += player.getLostChips();
		}
		this.activePlayer.addChips(kitty);
	}

	*/
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
		return this.activePlayer;	
	}

	
	
	private void finalReadOut() {
		System.out.println("Your Score:");
		ArrayList<Integer> scores = activePlayer.getScoreboard();
		for (int i = 0; i < scores.size(); i+=2) {
			System.out.println("Die 1: " + scores.get(i) + "    Die 2: " + scores.get(i+1));
		}
		System.out.println("Total Score: " + this.activePlayer.getFinalScore()); 
		System.out.println("Total Lost Chips: " + (activePlayer.getLostChips()));
	}
	
	public int[] diceRoll() {
		dice.roll();
		currentRoll = dice.getDicePair();
		activePlayer.playerGetsDiceRoll(currentRoll);
		activePlayer.updateForSpecial(isSpecial());
		return currentRoll;
	}
	
	/*
	public void singleTurn() {
		while(activePlayer.getTurnStatus()) {
			this.singleRoll();
		}
		this.finalReadOut();
	}
	
	public void playerRollsOrNot(char decision) {
		playerDecision(decision);
		singleRoll();
	}*/

	
	public RollTypes isSpecial() {
		advisor.setRollType(currentRoll);
		return advisor.getRollType();
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
	
	public void playerDecision(char decision) {
		if (decision == 'y' || decision == 'Y') {
			this.playerDecision = true;
		}
		else {
			this.playerDecision = false;
		}

	}
	
	public boolean getPlayerDecision() {
		return this.playerDecision;
	}
	
	public void endTurn(boolean endOrNot) {
		if (endOrNot == true) {
			activePlayer.endTurn();
		}
	}
	




}


	

