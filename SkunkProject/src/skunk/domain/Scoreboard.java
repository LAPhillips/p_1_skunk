package skunk.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scoreboard {
	private ArrayList<Integer> singleTurn;
//	private HashMap<Integer, List> playerGameScore;
	
	public Scoreboard() {
		this.singleTurn = new ArrayList<>();
//		this.playerGameScore = new HashMap<Integer, List>();
	}

	public ArrayList<Integer> getTurnScores() {
		return this.singleTurn;
	}
	
	public int getSpecificTurnScores(int index) {
		return this.singleTurn.get(index);
	}

	public void recordRoll(int newRoll) {
		singleTurn.add(newRoll);
	}

}
