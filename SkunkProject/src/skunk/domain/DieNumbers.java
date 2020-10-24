package skunk.domain;

public class DieNumbers {
	private int rollNumbers;
	int counter;
	
	DieNumbers(){
		this.rollNumbers = 1;
		this.counter = 1;
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

	public void enteredArray(int [] dieNumbers) {
		if (this.counter >= dieNumbers.length) {
		counter = 0;	
		}
		this.rollNumbers = dieNumbers[counter];
		counter++;
	}
}
