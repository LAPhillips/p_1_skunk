package skunk.domain;

public class Turn {
	private Boolean status;
	
	Turn(){
		this.status = true;
	}

	public Boolean getTurnStatus() {
		return this.status;
	}

	public void endTurn() {
		this.status = false;
	}



}
