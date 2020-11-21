package skunk.domain;

public class Controller {
	GamePlay play;
	
	public Controller() {
		this.play = new GamePlay();
	}
	
	public Player getPlayer() {
		return play.getActivePlayer();
	}
	
	public int[] diceRoll() {
		return play.diceRoll();
	}

	public RollTypes getRollType() {
		return play.isSpecial();
	}
	
	public void setNumberOfPlayers(int numberPlayers) {
		play.createPlayers(numberPlayers);
	}
	
	public void setPlayerNames(String name) {
		play.createPlayer(name);
	}
	
	public boolean yesOrNo(char decision) {
		play.playerDecision(decision);
		return play.getPlayerDecision();
	}
	
	public void isTurnOver(boolean overOrNot) {
		play.endTurn(overOrNot);
	}
	
	public Player nextPlayer() {
		return play.nextPlayer();
	}
	
	public Player winner() {
		return play.winner();
	}
	
	//only need this for Junit tests
	public GamePlay getGamePlay() {
		return play;
	}
	
	public int[] diceRoll(int die1, int die2) {
		return play.diceRoll(die1, die2);
	}
	

}
