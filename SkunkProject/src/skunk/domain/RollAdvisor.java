package skunk.domain;

public class RollAdvisor {
	private RollTypes rollType;
	
	public RollAdvisor() {
		this.rollType = RollTypes.NORMAL; // only ever reports the most recent roll
	}
	
	public Boolean isSpecial(int [] diceRoll) {
		if (diceRoll[0] == 1 || diceRoll[1] == 1) {
			return true;
		}
		else if ((diceRoll[0] == 1 || diceRoll[1] == 1) && (diceRoll[0] == 2 && diceRoll[1] == 1)) {
			return true;
		}
		return false;
	}
	
	
	public void setRollType(int[] scores) {
		int score1 = scores[0];
		int score2 = scores[1];
		
		if (score1 == 1) {
			if (score2 == 1) {
				this.rollType = RollTypes.DOUBLE_SKUNK; //1,1
			}
			else if (score2 == 2){
				this.rollType = RollTypes.SKUNK_DEUCE; // 1,2
			}
			else {
				this.rollType = RollTypes.SKUNK; // 1,x
			}
		}
		else if (score1 == 2 && score2 == 1) {
				this.rollType = RollTypes.SKUNK_DEUCE; // 2,1
		}
		else if (score2 == 1) {
			this.rollType = RollTypes.SKUNK; // x,1
		}
		else {
			this.rollType = RollTypes.NORMAL;
		}
	}
	

	public RollTypes getRollType() {
		return this.rollType;
	}
}
