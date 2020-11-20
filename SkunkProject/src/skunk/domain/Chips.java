package skunk.domain;

public class Chips {
	private int numChips;

	public Chips(){
		this.numChips = 50;
	}
	
	public int getChips() {
		return this.numChips;
	}
	
	public void subtractChips(int amount) {
		this.numChips -= amount;
	}

	public void addChips(int amount) {
		this.numChips += amount;
	}
	
	public int lostChips() {
		return 50 - this.numChips;
	}
	
	public int calculateChipChange(RollTypes roll) {
		if (roll == RollTypes.SKUNK) {
			return 1;
		}
		else if (roll == RollTypes.SKUNK_DEUCE){
			return 2;
		}
		else if (roll == RollTypes.DOUBLE_SKUNK){
			return 4;
		}
		return 0;
	}
	
	public void adjustChipsForRoll(RollTypes roll) {
		int lost = calculateChipChange(roll);
		subtractChips(lost);
	}

}
