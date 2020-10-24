package skunk.domain;

public class DieNumbers {
	private int rollNumbers;
	
	DieNumbers(){
		this.rollNumbers = 0;
	}

	public void randomOneToSix() {
		this.rollNumbers = (int) (Math.random() * 6 + 1);
	}
	
	public int getDieNumbers() {
		return rollNumbers;
	}

	public void fixed(int fixedNumber) {
		this.rollNumbers = fixedNumber;
	}

	public void sequencedNumbers() {
		if(this.rollNumbers == 1) {
			this.rollNumbers = 3;
		}
		else {
			this.rollNumbers = 1;
		}
	}

	public void enteredArray() {
		this.rollNumbers = 1;
		
	}
}
