package skunk.domain;
import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Skunk");
		int [] array = {1, 2, 3, 4};
		Die skunkDice = new Die();
		
		//rolling dice
		

		skunkDice.roll(5);
		int roll = skunkDice.getLastRoll();
		System.out.println(roll);
		skunkDice.roll();
		roll = skunkDice.getLastRoll();
		System.out.println(roll);
		skunkDice.roll();
		roll = skunkDice.getLastRoll();
		System.out.println(roll);
		skunkDice.roll();
		roll = skunkDice.getLastRoll();
		System.out.println(roll);
	}

}
