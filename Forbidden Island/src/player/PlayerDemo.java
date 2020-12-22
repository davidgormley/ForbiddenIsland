package player;

import cards.*;

/**
 * This is a class to demonstrate functionality of classes in player package.
 * 
 * @author:  Owen Ryan-Hanbury, David Gormley and Srinithi Ramprasad
 * @date:    201223
 * @version: 1.0
 */

public class PlayerDemo {

	public static void main(String[] args) {
		// create a player
		Player eric = new Player("Eric");
		eric.setRole("Engineer");
		eric.giveCard(new Card("The Earth Stone", CardType.TREASURE));
		eric.viewInventory();
		
		

	}

}
