package myskunk.pl;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdIn;
import skunk.domain.Controller;
import skunk.domain.Player;
import skunk.domain.RollTypes;

public class SkunkUI {
	private Controller control;
	private int numberPlayers;
	private Player player;

	
	public SkunkUI() {
		this.control = new Controller();
		this.numberPlayers = 0;
		this.player = null;

	}
	
	public void fullGame() {
		startGame();
		howManyPlayers();
		playerNames();
		round();
	}
	
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
		setActivePlayer();
	}
	
	public void singleRoll() {
		System.out.println(this.player.getPlayerName() + " rolls....");
		int[] currentRoll = control.diceRoll(); //rolls and records the roll
		diceRollReadout(currentRoll[0], currentRoll[1]); 
		checkSpecial(currentRoll); //checks to see if the roll is special
		System.out.println("Current Turn Score: " + player.getTurnScore());
		System.out.println();
	}
		
	
	public void checkSpecial(int[] currentRoll) {
		RollTypes rollType = control.getRollType();
		if (rollType != RollTypes.NORMAL) {
			player.updateForSpecial(rollType);
			System.out.println(rollType.toString());
			player.updateTurnScore(currentRoll, true);
			control.isTurnOver(true);
			player.endTurn();
		}
		else {
			player.updateTurnScore(currentRoll, false);
		}
	}
	
	public void singleTurn() {
		while(player.getTurnStatus()) {
			System.out.println(player.getPlayerName() + ", do you want to roll? [Y/N]");
			char decision = StdIn.readString().charAt(0);
			if (yesOrNo(decision)) {
				singleRoll();
			}
			else {
				player.endTurn(); 
			}
		}
		turnReadout();
	}
	
	
	public void round() {
		while(player.getFinalScore() < 25){
			singleTurn();
			System.out.println();
			if(player.getFinalScore() >= 25) {
				break;
			}
			player = control.nextPlayer();
			System.out.println("Now it is " + player.getPlayerName() + "'s turn.");
		}
		finalRound();
		finalScores();
	}
	
	
	public void finalScores() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println();
		Player winner = control.winner();
		System.out.println(winner.getPlayerName() + " has the highest score. " + winner.getPlayerName() + " wins!");
		System.out.println();
		System.out.println(" FINAL SCORES");
		System.out.println();
		for (int i = 0; i < numberPlayers; i++) {
			player = control.nextPlayer();
			System.out.println(player.toString());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	public void finalRound() {
		System.out.println(player.getPlayerName() + " scored 100 points or more. Now everyone else gets once more chance to roll");
		player.updateFinalTurn();
		player = control.nextPlayer();
		while(player.getFinalTurn()) {
			singleTurn();
			player.updateFinalTurn();
			player = control.nextPlayer();
		}

	}
	
	private void turnReadout() {
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

	public boolean yesOrNo(char decision) {
		return control.yesOrNo(decision);
	}
	
	public void setActivePlayer() {
		this.player = control.getPlayer();
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
