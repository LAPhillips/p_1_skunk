package skunk.domain;

public class DieNumbers {
	private int rollNumbers;
	
	DieNumbers(){
		this.rollNumbers = 0;
	}

	public void randomOneToSix() {
		this.rollNumbers = (int) (Math.random() * 6 + 1);
	}
	
	public int getDieNumebrs() {
		return rollNumbers;
	}

	public void fixed() {
		this.rollNumbers = 7;
		
	}
}
