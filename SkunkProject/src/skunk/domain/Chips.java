package skunk.domain;

public class Chips {
	private int numChips;
	private int change;
	private int netLost;
	
	
	public Chips(){
		int numChips = 50;
		int netLost = 0;
		this.change= 0;
	}
	
	public int getNumChips() {
		return this.numChips;
	}

	public int getNetLost() {
		return this.netLost;
	}
	
	public void adjustChips(int chipChange) {
		this.numChips += chipChange;
	}

	public int amountChange() {
		return change;
	}
	
	public int adjustNetChips(RollTypes roll) {
		calculateChipChange(roll);
		this.netLost += this.change;
		return this.netLost;
	}

	public void calculateChipChange(RollTypes roll) {
		if (roll == RollTypes.SKUNK) {
			this.change = 1;
		}
		else if (roll == RollTypes.SKUNK_DEUCE){
			this.change = 2;
		}
		else if (roll == RollTypes.DOUBLE_SKUNK){
			this.change = 4;
		}
		else {
			this.change = 0;
		}	
	}

}
