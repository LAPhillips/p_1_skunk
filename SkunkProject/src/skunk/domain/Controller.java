package skunk.domain;

public class Controller {
	GamePlay play;
	
	public Controller() {
		this.play = new GamePlay();
	}
	
	public void setNumberOfPlayers(int numberPlayers) {
		play.createPlayers(numberPlayers);
	}
	
	public void setPlayerNames(String name) {
		play.createPlayer(name);
	}
	
	public int[] diceRoll() {
		return play.diceRoll();
	}
	
	public boolean yesOrNo(char decision) {
		play.playerDecision(decision);
		return play.getPlayerDecision();
	}
	
	public Player getPlayer() {
		return play.getActivePlayer();
	}
	
	public RollTypes getRollType() {
		return play.isSpecial();
	}
	
	public void isTurnOver(boolean overOrNot) {
		play.endTurn(overOrNot);
	}
	
	public Player nextPlayer() {
		return play.nextPlayer();
	}
	
	public Player winner() {
		Player winner = play.highestScore();
		play.subtractFinalChips();
		play.giveWinnerChips(winner);
		play.setPlayerTracker(0);
		return winner;
	}
	

	
}
