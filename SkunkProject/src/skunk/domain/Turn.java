package skunk.domain;

public class Turn {
	private boolean status;
	private boolean finalTurn;
	
	public Turn(){
		this.status = true;
		this.finalTurn = true;
	}

	public Boolean getTurnStatus() {
		return this.status;
	}

	public void endTurn() {
		this.status = false;
	}
	
	public void startNewTurn() {
		this.status = true;
	}
	
	public void updateFinalTurn() {
		this.finalTurn = false;
	}
	
	public boolean getFinalTurn() {
		return this.finalTurn;
	}
	
}
