package skunk.domain;

public class Chips {
	private int numChips;
	private final int STARTING_CHIPS = 50;
	private final int SKUNK_LOSS = 1;
	private final int DOUBLESKUNK_LOSS = 4;
	private final int SKUNK_DEUCE_LOSS = 2;

	public Chips(){
		this.numChips = STARTING_CHIPS;
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
		return STARTING_CHIPS - this.numChips;
	}
	
	public int calculateChipChange(RollTypes roll) {
		if (roll == RollTypes.SKUNK) {
			return SKUNK_LOSS;
		}
		else if (roll == RollTypes.SKUNK_DEUCE){
			return DOUBLESKUNK_LOSS;
		}
		else if (roll == RollTypes.DOUBLE_SKUNK){
			return SKUNK_DEUCE_LOSS;
		}
		return 0;
	}
	
	public void adjustChipsForRoll(RollTypes roll) {
		int lost = calculateChipChange(roll);
		subtractChips(lost);
	}

}
