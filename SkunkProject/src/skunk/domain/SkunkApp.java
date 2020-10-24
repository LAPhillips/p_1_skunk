package skunk.domain;
import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Skunk");
		Dice skunkDice = new Dice();
		skunkDice.roll();
		int roll = skunkDice.getLastRoll();
		System.out.println(roll);
		
		
		
		
	

	}

}
