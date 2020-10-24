package skunk.domain;
import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Skunk");
		int [] array = {1, 2, 3, 4};
		Dice skunkDice = new Dice();
		
		//rolling dice
		skunkDice.roll();
		System.out.println(skunkDice.toString());;



	}

}
