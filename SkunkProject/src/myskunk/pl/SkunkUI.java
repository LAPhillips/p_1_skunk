package myskunk.pl;


import edu.princeton.cs.introcs.StdIn;
import skunk.domain.Controller;

public class SkunkUI {
	private String playerName;
	private char playerInputs;
	private Controller control; 

	public SkunkUI(){
		this.control = new Controller();
		this.playerName = control.getPlayerName();
		this.playerInputs = control.getsPlayerDecision();
	}
	
	public void doesPlayerRoll() {
		do {
			this.playerRolls();
			if(control.startNewRoll() == false) {
				this.playerRollsSpecial();
			}
			else {
				rollAgain();
			}
			
		} while(control.startNewRoll());
		playerEndsTurn();
	}
	
	public void rollAgain() {
		System.out.println(control.getPlayerName() + ", do you want to roll again? [Y/N]");
		playerInputs = StdIn.readString().charAt(0);
		control.setPlayerInput(playerInputs);
	}
	
	public void enterName() {
		System.out.println("What is your name?");
		String playerName = StdIn.readLine();
		control.setsPlayerName(playerName);
	}
	
	public void playerRolls() {
//for testing only
//		control.setsPlayerName("<Your Name>");
//
		System.out.println();
		System.out.println(control.getPlayerNameFromManager() + " rolls .... ");
		int [] currentRoll = control.shareRoll();
		
		//UI design
		String rollLabel1 = "First Die:";
		String rollLabel2 = "Second Die:";
		String rollLabel3 = "Roll Total:";
		String format = "%-20s%s%n";;
		System.out.printf(format, rollLabel1, currentRoll[0]);
		System.out.printf(format, rollLabel2, currentRoll[1]);
		System.out.println("------------------------");
		System.out.printf(format, rollLabel3, control.rollTotal());
		System.out.println();

		System.out.println("Total Score: " + control.totalTurnScore());
	}
	
	public void playerEndsTurn() {
	    StdIn.readLine(); //requires a player presses enter to continue 
	    System.out.println(control.getPlayerNameFromManager() + ", here is your turn review: ");
		System.out.println("----------------------------------------------");
		int rolls = control.numberOfRolls();
		int announceRolls = 1;
		for (int i = 0; i < rolls*2; i++) {
			System.out.print("(ROLL #" + (announceRolls) + ") ");
			System.out.print(" Die One: " + control.reportsSpecificRoll(i));
			i++;
			System.out.println("      Die Two: " + control.reportsSpecificRoll(i));
			announceRolls++;
		}
		System.out.println("----------------------------------------------");
		System.out.println("TOTAL TURN SCORE: " + control.totalTurnScore());
		System.out.println("CHIPS LOST: " + control.getLostChips());
	}
	
	public void playerRollsSpecial() {
		System.out.println("You rolled a " + control.reportsSpecialRoll().toString() + "!");
		System.out.println("Press [ENTER] to continue.");
	    StdIn.readLine(); //requires a player presses enter to continue 
		System.out.println();
	}
	

	
	
	
	/*+
	 * UI Needs to:
	 * 
	 * 
	 * 
	 * PerTurn
	 * 1. Intro
	 * 		a. player name
	 * 		b. do they wish to roll
	 * 
	 * 2. Report users roll outcome
	 * 		a. name of player x
	 * 		b. value of each dice x
	 * 		c. kind of Skunk (single/deuce/double) if any
	 * 		d. current turn score for player
	 *3. Final end of turn summary
	 * 		a. player's name x
	 * 		b. complete sequence of rolls x
	 * 		c. final turn score x
	 * 		d. how many chips they lost x
	 * 4. Turn ends 
	 * 		a. after either user declines to roll OR skunk
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
