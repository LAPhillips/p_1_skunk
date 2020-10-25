package myskunk.pl;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

public class SkunkUI {
	private Scanner scan;
	
	public SkunkUI(){
		this.scan = new Scanner(System.in);
	}
	
	public void enterName() {
		System.out.println("What is your name?");
		String playerName = scan.nextLine();
		System.out.println("Thank you " + playerName);
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