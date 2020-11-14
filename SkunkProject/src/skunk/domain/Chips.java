package skunk.domain;

public class Chips {
	private int numChips;
	private int change;
	
	
	Chips(){
		this.numChips = 50;
		this.change= 0;
	}

	public int getNumChips() {
		return this.numChips;
	}

	public void adjustChips(int chipChange) {
		this.numChips += chipChange;
	}

	public int amountChange() {
		return change;
	}

	public void calculateChipChange(RollTypes roll) {
		if (roll == RollTypes.SKUNK) {
			this.change = -1;
		}
		else if (roll == RollTypes.SKUNK_DEUCE){
			this.change = -2;
		}
		else if (roll == RollTypes.DOUBLE_SKUNK){
			this.change = -4;
		}
		else {
			this.change = 0;
		}	
	}

}
