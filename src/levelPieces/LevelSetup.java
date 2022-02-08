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
			
		}
		//
		if (num == 2) {
			
		}
	}
	
	
}
