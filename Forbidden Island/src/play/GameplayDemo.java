package play;

import gameboard.Board;
import player.Adventurers;
import java.util.Scanner;
import game.*;
import cards.*;

public class GameplayDemo {
	//===========================================================
    // Testing
    //===========================================================
	public static void main(String args[]) {
		Adventurers players = Adventurers.getInstance();
		Board board = Board.getInstance();
		board.printBoard();
		Scanner in = new Scanner(System.in);
		
		
		/**
		 * Test player setup
		 */
		SetPlayers playerCtrl = new SetPlayers(in);
		System.out.println(players.getPlayer(1).getRole());
		int[] pos1 = players.getPlayer(1).getPawnPosition();
		System.out.println("[" + pos1[0] + "][" + pos1[1] + "] "
				+ board.getTileName(pos1[0], pos1[1]));
		
		System.out.println(players.getPlayer(2).getRole());
		int[] pos2 = players.getPlayer(2).getPawnPosition();
		System.out.println("[" + pos2[0] + "][" + pos2[1] + "] "
				+ board.getTileName(pos2[0], pos2[1]));
		
		/**
		 * Test player turn
		 */
		players.getPlayer(1).giveCard(new Card("The Ocean Chalice",CardType.TREASURE));
		players.getPlayer(1).setPos(pos2[0],pos2[1]);
		Turn t = new Turn(in,1);
		t = new Turn(in,2);
		
		/**
		 * Test Sandbag
		 */
		int[] fl = board.tileCoords("Fool's Landing");
		System.out.println("Fool's Landing is located at (" + fl[0] + ", " + fl[1] + ").");
		
		// flood Fool's Landing
		board.floodTile("Fool's Landing");
		Card sbag = new Card("Sandbag",CardType.SANDBAG);
		
		// give Player 1 a Sandbag card and move to FL
		players.getPlayer(1).giveCard(sbag);
		players.getPlayer(1).setPos(fl[0], fl[1]);
		
		// use card
		Sandbag s = new Sandbag();
		
		// try again with Player 2
		s.doSandbag();
		
		/**
		 * Test Helicopter
		 */
		Card heli = new Card("Helicopter Lift",CardType.HELI);
		players.getPlayer(1).giveCard(heli);
		
		Helicopter h = new Helicopter();
		pos1 = players.getPlayer(1).getPawnPosition();
		pos2 = players.getPlayer(2).getPawnPosition();
		
		System.out.print("P1: " + board.getTileName(pos1[0], pos1[1]) + "\nP2: "
				+ board.getTileName(pos2[0], pos2[1]));
		
		/**
		 * Test Move
		 */
		Move m = new Move(1);
	}
}
