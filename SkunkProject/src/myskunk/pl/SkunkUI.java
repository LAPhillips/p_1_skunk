package myskunk.pl;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdIn;
import skunk.domain.Controller;
import skunk.domain.Player;
import skunk.domain.RollTypes;

public class SkunkUI {
	private Controller control;
	private int numberPlayers;

	
	public SkunkUI() {
		this.control = new Controller();
		this.numberPlayers = 0;
	}
	
	public void fullGame() {
		startGame();
		howManyPlayers();
		playerNames();
		round();
	}
	
	//*****Game Setup*****************
	public void startGame() {
		System.out.println("Welcome to Skunk");
		System.out.println();
		System.out.println("Would you like to review the rules before we start?");
		//rules system
		
	}
	
	public void howManyPlayers() {
		System.out.println("How many players? ");
		numberPlayers = StdIn.readInt();
		control.setNumberOfPlayers(numberPlayers);
	}
	
	public void playerNames() {
		for (int i = 0; i < numberPlayers; i++) {
			System.out.println("What is player #" + (i+1) + "'s name?");
			String playerName = StdIn.readString();
			control.setPlayerNames(playerName);
		}
	}
	
	//*****Game Play*****************
	public void singleRoll() { 
		Player player = control.getPlayer();
		System.out.println(player.getPlayerName() + " rolls....");
		int[] currentRoll = control.diceRoll(); //rolls and records the roll
		diceRollReadout(currentRoll[0], currentRoll[1]); 
		checkSpecial(currentRoll); //checks to see if the roll is special
		System.out.println("Current Turn Score: " + player.getTurnScore());
		System.out.println();
	}
		
	
	public void checkSpecial(int[] currentRoll) {
		Player player = control.getPlayer();
		RollTypes rollType = control.getRollType();
		if (rollType != RollTypes.NORMAL) {
			System.out.println(rollType.toString());
			player.updateTurnStatusAndScore(currentRoll, true);
		}
		else {
			player.updateTurnStatusAndScore(currentRoll, false);
		}
	}
	
	public void singleTurn() {
		Player player = control.getPlayer();
		while(player.getTurnStatus()) {
			System.out.println(player.getPlayerName() + ", do you want to roll? [Y/N]");
			char decision = StdIn.readString().charAt(0);
			if (control.yesOrNo(decision)) {
				singleRoll();
			}
			else {
				player.endTurn(); 
			}
		}
		player.checkForFinalTurn();
		turnReadout();
	}
	
	
	public void round() {
		Player player = control.getPlayer();
		while(player.getFinalTurn()){
			singleTurn();
			System.out.println();
			if(!player.getFinalTurn()) {
				break;
			}
			player = control.nextPlayer();
			System.out.println("Now it is " + player.getPlayerName() + "'s turn.");
		}
		finalRound();
		finalScores();
	}
	
	
	public void finalScores() {
		Player player = control.getPlayer();
		System.out.println();
		System.out.println("WINNER:");
		Player winner = control.winner();
		System.out.println(winner.getPlayerName() + " has the highest score. " + winner.getPlayerName() + " wins!");
		System.out.println();
		System.out.println("FINAL SCORES:");                    
		for (int i = 0; i < numberPlayers; i++) {
			System.out.println();
			player = control.nextPlayer();
			System.out.println(player.toString());
		}
	}
	
	public void finalRound() {
		Player player = control.getPlayer();
		System.out.println(player.getPlayerName() + " scored 100 points or more. Now everyone else gets once more chance to roll");
		player = control.nextPlayer();
		while(player.getFinalTurn()) {
			singleTurn();
			player.updateFinalTurn();
		}

	}
	
	private void turnReadout() {
		Player player = control.getPlayer();
		 StdIn.readLine(); //requires a player presses enter to continue 
		    System.out.println(player.getPlayerName() + ", here is your turn review: ");
			System.out.println("----------------------------------------------");
			ArrayList<Integer> turnScores = player.getScoreboard();
			int announceRolls = 1;
			
			for (int i = 0; i < turnScores.size(); i+=2) {
				System.out.print("(ROLL #" + (announceRolls) + ") ");
				System.out.println("Die One: " + turnScores.get(i) + "      Die Two: " + turnScores.get(i + 1));
				announceRolls++;
			}
			System.out.println("----------------------------------------------");
			System.out.println("TOTAL TURN SCORE: " + player.getTurnScore());
			System.out.println("TOTAL GAME SCORE:  " + player.getFinalScore());
			System.out.println("CHIPS LOST: " + player.getLostChips());
		
	}
	
	public void diceRollReadout(int die1, int die2) {
		//UI design
				String rollLabel1 = "First Die:";
				String rollLabel2 = "Second Die:";
				String rollLabel3 = "Roll Total:";
				String format = "%-20s%s%n";;
				System.out.printf(format, rollLabel1, die1);
				System.out.printf(format, rollLabel2, die2);
				System.out.println("------------------------");
				System.out.printf(format, rollLabel3, (die1+die2));
				System.out.println();
	}
	
	
	
	
	
	
}
