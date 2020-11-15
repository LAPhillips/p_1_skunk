package myskunk.pl;


import edu.princeton.cs.introcs.StdIn;
import skunk.domain.Controller;
import skunk.domain.Player;

public class SkunkUI {
	private char playerInputs;
	private Controller control; 

	public SkunkUI(){
		this.control = new Controller();
		this.playerInputs = 'Y'; 
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
		System.out.println(control.getPlayerNameFromManager() + ", do you want to roll again? [Y/N]");
		playerInputs = StdIn.readString().charAt(0);
		control.sharePlayerInputs(playerInputs);
	}
	
	public void setupGame() {
		this.howMany();
		System.out.println("Great, we will make a game with " + this.control.getNumPlayers() + " players.");
		for (int i = 0; i < this.control.getNumPlayers(); i++) {
			this.enterName(i+1);
		}
	}
	
	public void howMany() {
		System.out.println("How many players are there?");
		int numberPlayers = StdIn.readInt();
		this.control.setupGame(numberPlayers);
	}
	
	public void enterName(int playerNumber) {
		System.out.println("What is player #" + playerNumber + "'s name?");
		String playerName = StdIn.readString();
		control.sharePlayerName(playerName);
	}
	
	public void playerRolls() {
//for testing only
		control.sharePlayerName("<Your Name>");
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
	
}
