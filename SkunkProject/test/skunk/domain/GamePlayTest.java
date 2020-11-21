package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GamePlayTest {
	
	@Test
	void gp_gets_active_player() {
		GamePlay play = new GamePlay();
		Player player = play.getActivePlayer();
		String name = player.getPlayerName();
		assertTrue(name.equals(" ")); //default name is " " 
	}
	
	@Test
	void gp_sets_active_player() {
		GamePlay play = new GamePlay();
		Player player = play.getActivePlayer();
		String name = player.getPlayerName();
		assertTrue(name.equals(" ")); //default name is " " 
		
		Player newPlayer = new Player("newPlayer");
		play.setActivePlayer(newPlayer);
		player = play.getActivePlayer();
		name = player.getPlayerName();
		assertTrue(name.equals("newPlayer")); //name should reflect new Player Name 
	}
	
	@Test
	void gp_gets_all_players() {
		GamePlay play = new GamePlay();
		Player[] players = play.getPlayers();
		assertNull(players); //default state is null
	}
	
	@Test
	void gp_gets_player_tracker() {
		GamePlay play = new GamePlay();
		int tracker = play.getPlayerTracker();
		assertEquals(0,tracker); //default is 0
	}
	
	@Test
	void gp_sets_player_tracker() {
		GamePlay play = new GamePlay();
		int tracker = play.getPlayerTracker();
		assertEquals(0,tracker); //default is 0
		
		play.setPlayerTracker(2);
		tracker = play.getPlayerTracker();
		assertEquals(2, tracker); //now tracker should be set to 2
	}

	@Test
	void gp_gets_player_decision() {
		GamePlay play = new GamePlay();
		boolean decision = play.getPlayerDecision();
		assertTrue(decision); //default is true
	}

	@Test
	void gp_creates_new_playerArray() {
		GamePlay play = new GamePlay();
		play.createPlayers(50);
		int numberOfPlayers = play.getPlayers().length;
		assertEquals(50, numberOfPlayers); //Array should be made with 50 players
	}
	
	@Test
	void gp_creates_new_players() {
		GamePlay play = new GamePlay();
		play.createPlayers(2);
		play.createPlayer("first");
		play.createPlayer("second");
		Player [] players = play.getPlayers();
		Player first = players[0];
		Player second = players[1];
		assertTrue(first.getPlayerName().equals("first") && second.getPlayerName().equals("second")); //first name should be "first"/second "second" 
	}
	
	@Test
	void gp_adds_player_to_array_first_index_default_active() {
		GamePlay play = new GamePlay();
		play.createPlayers(3);
		Player player1 = new Player("first");
		play.addPlayer(player1);
		Player activePlayer = play.getActivePlayer();
		assertEquals(player1, activePlayer); //first one added should be active player
	}
	
	@Test
	void gp_gets_next_player_in_array() {
		GamePlay play = new GamePlay();
		play.createPlayers(2);
		play.createPlayer("first");
		play.createPlayer("second");
		Player activePlayer = play.getActivePlayer();
		assertTrue(activePlayer.getPlayerName().equals("first")); //first active player is named "first"
		
		activePlayer = play.nextPlayer();
		assertTrue(activePlayer.getPlayerName().equals("second")); //first active player is named "second"
		
		activePlayer = play.nextPlayer();
		assertTrue(activePlayer.getPlayerName().equals("first")); //loops back to first player
	}
	
	@Test
	void gp_rolls_dice_and_shares() {
		GamePlay play = new GamePlay();
		play.createPlayers(1);
		play.createPlayer("first");

		play.diceRoll(5, 2);
		Player player = play.getActivePlayer();
		ArrayList<Integer> scores = player.getScoreboard();
		int chips = player.getChips();
		assertEquals(5, scores.get(0)); //rolling dice records the new dice score
		assertEquals(50, chips); //for non-special rolls, chips should stay the same
		
		play.diceRoll(1,1); 
		scores = player.getScoreboard();
		chips = player.getChips();
		assertEquals(1, scores.get(2)); //rolling dice records the new dice score
		assertEquals(46, chips); //for double-skunk chips are reduced by 4	
	}
	
	@Test
	 void gp_can_report_what_rolls_are_special() {
		GamePlay play = new GamePlay();
		play.diceRoll(5, 5);
		RollTypes type = play.isSpecial();
		assertEquals(RollTypes.NORMAL, type); //a regular roll should be "normal"
		
		play.diceRoll(1, 1);
		type = play.isSpecial();
		assertEquals(RollTypes.DOUBLE_SKUNK, type); //1,1 should be double skunk
		
		play.diceRoll(1, 2);
		type = play.isSpecial();
		assertEquals(RollTypes.SKUNK_DEUCE, type); //1,2 should be a skunk and deuce
		
		play.diceRoll(1, 3);
		type = play.isSpecial();
		assertEquals(RollTypes.SKUNK, type); //1,3 should be a skunk
		
	}
	
	@Test
	void gp_interprets_player_decision() {
		GamePlay play = new GamePlay();
		play.playerDecision('y');
		boolean decision = play.getPlayerDecision();
		assertTrue(decision); //'y' should be true
		
		play.playerDecision('n');
		decision = play.getPlayerDecision();
		assertFalse(decision); //'n' should be false
		
		play.playerDecision('Y');
		decision = play.getPlayerDecision();
		assertTrue(decision); //'Y' should be true
		
		play.playerDecision(' '); //any character beyond y/Y will be considered no
		decision = play.getPlayerDecision();
		assertFalse(decision); //' ' should be false
	}
	
	@Test
	void gp_endsTurn_if_told_to() {
		GamePlay play = new GamePlay();
		play.createPlayers(1);
		play.createPlayer("first");
		Player player = play.getActivePlayer();
		boolean status = player.getTurnStatus();
		assertTrue(status); //starting out we expect true
		
		play.endTurn(false);
		status = player.getTurnStatus();
		assertTrue(status); //still should remain true
		
		play.endTurn(true);
		status = player.getTurnStatus();
		assertFalse(status); //now should be false
	}
	
	@Test
	void gp_gets_highest_score() {
		GamePlay play = new GamePlay();
		play.createPlayers(3);
		play.createPlayer("first");
		play.createPlayer("second");
		play.createPlayer("third");
		int[] currentRoll = play.diceRoll(10,10);  //not real dice rolls, but making it easier for me
		Player player = play.getActivePlayer();
		player.updateTurnStatusAndScore(currentRoll, false);
		player.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(50,50);
		Player secondPlayer = play.getActivePlayer();
		secondPlayer.updateTurnStatusAndScore(currentRoll, false);
		secondPlayer.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(5,5);
		Player thirdPlayer = play.getActivePlayer();
		thirdPlayer.updateTurnStatusAndScore(currentRoll, false);
		thirdPlayer.endTurn();
		
		Player winner = play.highestScore();
		assertEquals(secondPlayer, winner);
	}
	
	
	@Test
	void gp_removes_chips_from_all_players() {
		GamePlay play = new GamePlay();
		play.createPlayers(3);
		play.createPlayer("first");
		play.createPlayer("second");
		play.createPlayer("third");
		
		play.subtractFinalChips();
		Player player = play.getActivePlayer();
		int chips = player.getChips();
		assertEquals(40, chips); //because no score 10 chips removed
		
		play.nextPlayer();
		Player player2 = play.getActivePlayer();
		int chips2 = player2.getChips();
		assertEquals(40, chips2); //because no score 10 chips removed
		
		play.nextPlayer();
		Player player3 = play.getActivePlayer();
		int chips3 = player3.getChips();
		assertEquals(40, chips3); //because no score 10 chips removed
		
		play.nextPlayer();
		int[] currentRoll = play.diceRoll(10,10);  
		player = play.getActivePlayer();
		player.updateTurnStatusAndScore(currentRoll, false);
		player.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(50,50);
		Player secondPlayer = play.getActivePlayer();
		secondPlayer.updateTurnStatusAndScore(currentRoll, false);
		secondPlayer.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(5,5);
		Player thirdPlayer = play.getActivePlayer();
		thirdPlayer.updateTurnStatusAndScore(currentRoll, false);
		thirdPlayer.endTurn();
		
		play.subtractFinalChips(); //now only 5 chips should be subtracted from each player
		Player[] players = play.getPlayers();
		player = players[0];
		player2 = players[1];
		player3 = players[2];
		
		assertTrue(player.getChips() == 35 && player2.getChips() == 35 && player3.getChips() == 35);
	}
	
	@Test
	void gp_gives_chips_to_winner() {
		GamePlay play = new GamePlay();
		play.createPlayers(3);
		play.createPlayer("first");
		play.createPlayer("second");
		play.createPlayer("third");
		
		play.nextPlayer();
		int[] currentRoll = play.diceRoll(10,10);  
		Player player = play.getActivePlayer();
		player.updateTurnStatusAndScore(currentRoll, false);
		player.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(50,50);
		Player secondPlayer = play.getActivePlayer();
		secondPlayer.updateTurnStatusAndScore(currentRoll, false);
		secondPlayer.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(5,5);
		Player thirdPlayer = play.getActivePlayer();
		thirdPlayer.updateTurnStatusAndScore(currentRoll, false);
		thirdPlayer.endTurn();
		
		play.subtractFinalChips(); //now only 5 chips should be subtracted from each player
		Player[] players = play.getPlayers();
		player = players[0];
		secondPlayer = players[1];
		thirdPlayer = players[2];
		
		play.giveWinnerChips(secondPlayer);
		assertEquals(60, secondPlayer.getChips()); //got 10 chips from other players, and 5 that they had put in = total of 60
	}
	
	@Test
	void gp_gets_winner() {
		GamePlay play = new GamePlay();
		play.createPlayers(3);
		play.createPlayer("first");
		play.createPlayer("second");
		play.createPlayer("third");
		int[] currentRoll = play.diceRoll(10,10);  //not real dice rolls, but making it easier for me
		Player player = play.getActivePlayer();
		player.updateTurnStatusAndScore(currentRoll, false);
		player.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(50,50);
		Player secondPlayer = play.getActivePlayer();
		secondPlayer.updateTurnStatusAndScore(currentRoll, false);
		secondPlayer.endTurn();
		play.nextPlayer();
		
		currentRoll = play.diceRoll(5,5);
		Player thirdPlayer = play.getActivePlayer();
		thirdPlayer.updateTurnStatusAndScore(currentRoll, false);
		thirdPlayer.endTurn();
		
		Player winner = play.winner();
		assertEquals(secondPlayer, winner);//correct winner
		assertEquals(0, play.getPlayerTracker()); //player tracker set to 0
		assertEquals(60, secondPlayer.getChips()); //player should have 50 + 10 chips
	}
	
	
	
}
