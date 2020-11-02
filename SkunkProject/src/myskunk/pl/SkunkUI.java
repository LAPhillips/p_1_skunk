package myskunk.pl;
import java.util.Scanner;
import skunk.domain.Controller;

public class SkunkUI {
	private Scanner scan;
	private String playerName;
	private char playerInputs;
	private Controller control; 

	public SkunkUI(){
		this.scan = new Scanner(System.in);
		this.control = new Controller();
		this.playerName = control.getPlayerName();
		this.playerInputs = control.getsPlayerDecision();
	}
	
	public void doesPlayerRoll() {
		do {
			playerRolls();
			System.out.println("Do you want to roll again? [Y/N]");
			playerInputs = scan.next().charAt(0);
			control.setPlayerInput(playerInputs);
		} while(control.startNewRoll());
		playerEndsTurn();
	}
	
	public void enterName() {
		System.out.println("What is your name?");
		String playerName = scan.nextLine();
		control.setsPlayerName(playerName);
	}
	
	public void playerRolls() {
		System.out.println();
		System.out.println(control.getPlayerName() + " rolls .... ");
		int [] currentRoll = control.shareRoll();
		
		//UI design
		String rollLabel1 = "First Die:";
		String rollLabel2 = "Second Die:";
		String rollLabel3 = "Roll Total:";
		String rollLabel4 = "Grand Total:";
		String format = "%-20s%s%n";;
		System.out.printf(format, rollLabel1, currentRoll[0]);
		System.out.printf(format, rollLabel2, currentRoll[1]);
		System.out.println("------------------------");
		System.out.printf(format, rollLabel3, control.rollTotal());
		System.out.println();

		System.out.println("Total Score: " + control.totalTurnScore());
	}
	

	public void  playerEndsTurn() {
		System.out.println(playerName + ", here is your turn review: ");
		System.out.println("----------------------------------------------");
		int rolls = control.numberOfRolls();
		int announceRolls = 1;
		for (int i = 0; i < rolls*2; i++) {
			System.out.print("(TURN #" + (announceRolls) + ") ");
			System.out.print(" Die One: " + control.reportsSpecificRoll(i));
			i++;
			System.out.println("      Die Two: " + control.reportsSpecificRoll(i));
			announceRolls++;
		}
		
		System.out.println("TOTAL TURN SCORE:" + control.totalTurnScore());
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
	 * 		a. player's name
	 * 		b. complete sequence of rolls
	 * 		c. final turn score
	 * 		d. how many chips they lost
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
