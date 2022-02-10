// Lucas King & Mason Harless
// C07A KerPlop Game

package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.Player;
import gameEngine.GameEngine; 

public class LevelSetup {
	public static final int NUM_LEVELS = 2;
	
	public Drawable[] board = new Drawable[(GameEngine.BOARD_SIZE)];

	// getter for board, auto-generated
	public Drawable[] getBoard() {
		return board;
	}
	
	public void createLevel(int num) {
		// Only if the level is 1
		if (num == 1) {
			CautionSign sign = new CautionSign('!');
			ClayMine mine = new ClayMine('M', "Clay mine (Will hurt you if you step on it)", 12);
			PetGoat rupert = new PetGoat('R', "Goat named Rupert", 6);
			Teleporter teleporter = new Teleporter('T', "Will advance to next level immediatly", 8);
			Hopper hopper = new Hopper('H', "Will kill Player when next to him", 5);
			Gold gold1 = new Gold('G', "Gold (if you get two you escape)", 19);
			Gold gold2 = new Gold('G', "Gold (if you get two you escape)", 10);
			
			board[3] = sign;
			board[mine.getLocation()] = mine;
			board[rupert.getLocation()] = rupert;
			board[teleporter.getLocation()] = teleporter;
			board[hopper.getLocation()] = hopper;
			board[gold1.getLocation()] = gold1;
			board[gold2.getLocation()] = gold2;
			
			System.out.println("P - This player is you");
			System.out.println(gold1.toString());
			System.out.println(rupert.toString());
			System.out.println(hopper.toString());
			System.out.println(teleporter.toString());
			System.out.println(mine.toString());
			System.out.println(sign.character + "Caution Sign (Does nothing)");
		}
		// 
		if (num == 2) {
			CautionSign sign = new CautionSign('!');
			ClayMine mine1 = new ClayMine('M', "Clay mine (Will hurt you if you step on it)", 12);
			ClayMine mine2 = new ClayMine('M', "Clay mine (Will hurt you if you step on it)", 2);
			PetGoat rupert = new PetGoat('R', "Goat named Rupert", 6);
			Hopper hopper1 = new Hopper('H', "Will kill Player when next to him", 5);
			Hopper hopper2 = new Hopper('H', "Will kill Player when next to him", 15);
			Gold gold1 = new Gold('G', "Gold (if you get two you escape)", 19);
			Gold gold2 = new Gold('G', "Gold (if you get two you escape)", 10);
			
			board[3] = sign;
			board[mine1.getLocation()] = mine1;
			board[mine2.getLocation()] = mine2;
			board[rupert.getLocation()] = rupert;
			board[hopper1.getLocation()] = hopper1;
			board[hopper2.getLocation()] = hopper2;
			board[gold1.getLocation()] = gold1;
			board[gold2.getLocation()] = gold2;
			
			System.out.println("P - This player is you");
			System.out.println(gold1.toString());
			System.out.println(rupert.toString());
			System.out.println(hopper1.toString());
			System.out.println(mine1.toString());
			System.out.println(sign.character + "Caution Sign (Does nothing)");
		}
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		ArrayList<Moveable> moveable = new ArrayList<Moveable>();
		
		for (Drawable piece : board) {
			if (piece instanceof PetGoat || piece instanceof Teleporter || piece instanceof Hopper) {
				moveable.add((Moveable) piece);
			}
		}
		
		return moveable;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		ArrayList<GamePiece> interaction = new ArrayList<GamePiece>();
		
		for (Drawable piece : board) {
			if (piece instanceof PetGoat || piece instanceof Teleporter || piece instanceof ClayMine || piece instanceof Hopper || piece instanceof Gold) {
				interaction.add((GamePiece) piece);
			}
		}
		
		return interaction;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		for (Drawable piece : board) {
			if (piece instanceof Player) {
				return ((Player) piece).getLocation();
			}
		}
		
		return 0;
	}
		
}
