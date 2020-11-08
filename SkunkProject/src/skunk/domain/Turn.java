package skunk.domain;

public class Turn {
	private Boolean status;
	private int numberOfTurns;
	
	public Turn(){
		this.status = true;
		this.numberOfTurns = 1;
	}

	public Boolean getTurnStatus() {
		return this.status;
	}

	public void endTurn() {
		this.status = false;
	}

	public void playersDecision(char playerInput) {
		if (playerInput == 'Y' || playerInput == 'y') {
		}
		else {
			this.endTurn();
		}
	}

	public int getnumberOfTurns() {
		return this.numberOfTurns;
	}

	//this isn't used yet, but will be needed when there is more than one turn
	public void startNewTurn() {
		this.status = true;
		this.numberOfTurns ++;
	}
	
}
