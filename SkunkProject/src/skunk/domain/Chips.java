package skunk.domain;

public class Chips {
	private int numChips;
	
	Chips(){
		this.numChips = 50;
	}

	public int getNumChips() {
		return this.numChips;
	}

	public void adjustChips(int chipChange) {
		this.numChips += chipChange;
	}

}
