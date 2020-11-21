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
		System.out.println("Welcome to Skunk!");
		System.out.println();
		System.out.println("Would you like to review the rules before we start? [Y/N]");
		char decision = StdIn.readString().charAt(0);
		if (control.yesOrNo(decision)) {
			skunkRules();
		}
	}
	
	public void skunkRules() {
		System.out.println("DIRECTIONS FOR PLAYING:");
		System.out.println("------------------------");
		System.out.println("The object of the game is to accumulate a score of 100 points or more."); 
		System.out.println("Points are made by rolling the dice and combining the points on the two dice.");
		System.out.println("After a successful roll, can continue to roll to increase his score or can pass ");
		System.out.println("the dice and wait for his next turn. Passing the dice prevents the possibility ");
		System.out.println("of rolling a Skunk and losing his score.");
		
		System.out.println();
		System.out.println("EXAMPLE: If a player rolls 4 and 5 that gives him 9 points.  ");
		System.out.println("If the player decides roll the dice again and gets a 3 and 5 (8 points),  ");
		System.out.println("he would then have an accumulated total of 17 points for the two rolls. ");
		System.out.println("The player could choose to stop his turn and keep the 17 points.");
		System.out.println("If he continued to roll, and rolled a Skunk, he would lose all of the 17 points.");
		
		System.out.println();
		System.out.println("A game can have any number of players. At least two players is recommended. Each player starts with 50 chips.");
		System.out.println();
		
		System.out.println("ROLL PENALTIES:");
		System.out.println("----------------");
		System.out.println("Skunk:");
		System.out.println("What is it? ---- A skunk is any roll with a single 1 (without a 2 or another 1). ");
		System.out.println("What happens? ---- The score for that turn is voided and the player ends his turn.");
		System.out.println("How many lost chips? ---- One chip placed in the Kitty (where lost chips are kept).");
	
		System.out.println();
		System.out.println("Skunk & Deuce:");
		System.out.println("What is it? ---- A roll with a 1 and 2 on the dice. ");
		System.out.println("What happens? ---- The score for that turn is voided and the player ends his turn.");
		System.out.println("How many lost chips? ---- 2 chips placed in the Kitty.");
	
		System.out.println();
		System.out.println("Double Skunk:");
		System.out.println("What is it? ---- A roll with two 1s on the dice (snake-eyes). ");
		System.out.println("What happens? ---- The ENTIRE accumulated score is voided and the player ends his turn.");
		System.out.println("How many lost chips? ---- 4 chips placed in the Kitty.");
	
		System.out.println();
		System.out.println("WINNING THE GAME:");
		System.out.println("------------------");
		System.out.println("The first player to get 100 or more points can continue to score as many points over 100 ");
		System.out.println("as he believes is needed to win. When he stops, each other player gets another chance to roll and best his score.  ");
		System.out.println("Once each player has rolled a last time, the player with the highest score is declared the winner.");
		System.out.println();
		System.out.println("The winner of each game collects all chips in Kitty. The winner also gets 5 chips from every losing player,");
		System.out.println("except for those with no score, -- the winner gets 10 chips from those players.");
		
	}
	
	public void howManyPlayers() {
		System.out.println();
		System.out.println("---------------STARTING THE GAME------------------");
		System.out.println();
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
	
	public void turnReadout() {
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
