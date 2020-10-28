package myskunk.pl;
import java.util.Scanner;
import skunk.domain.Controller;

public class SkunkUI {
	private Scanner scan;
	private String playerName;
	private Controller control; 

	public SkunkUI(){
		this.scan = new Scanner(System.in);
		this.control = new Controller();
		playerName = "noName";
	}
	
	public void enterName() {
		System.out.println("What is your name?");
		String playerName = scan.nextLine();
		control.setsPlayerName(playerName);
	}
	
	public void StartTurn() {
		int [] roll = control.shareRoll();
		System.out.println(control.getPlayerName() + " rolls a.... " + roll[0] + " and " + roll[1]);
		System.out.println("Total score: " );
	
	}
	
	
	
	
	/*
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
	 * 		a. name of player
	 * 		b. value of each dice
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
