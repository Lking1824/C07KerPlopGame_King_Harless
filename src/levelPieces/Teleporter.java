// Lucas King & Mason Harless
// C07A KerPlop Game

package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Teleporter extends GamePiece implements Moveable {
	
	// Teleporter constructor auto-generated
	public Teleporter(char symbol, String label, int location) {
		super(symbol, label, location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub

		// Move the Teleporter forward
		if (playerLocation == getLocation()) {
			return InteractionResult.ADVANCE;
		}
		
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Keep track of empty spaces
		int empty = 0;
		
		// Iterate through the game board
		for (Drawable piece : gameBoard) {
			if (piece == null) {
				empty ++;
			}
		}
		
		// Create array tracking variable
		int tracker = 0;
		// Create array of the null spaces
		int[] array = new int[empty];
		
		// Add all null spaces in board into array
		for (int i = 0; i < gameBoard.length; i++) {
			// If position is null
			if (gameBoard[i] == null) {
				array[tracker] = i;
				tracker ++;
			}
		}
		
		// Create random 
		Random rand = new Random();
		// Create upper bound
		int maxBound = empty;
		
		// Create a random number
		int randomInt = rand.nextInt(maxBound);
		
		// Create new position variable
		int newPosition = array[randomInt];
		// Create old position
		int oldPosition = getLocation();
		
		// Update the board
		gameBoard[newPosition] = gameBoard[oldPosition];
		// Update the board with the oldPosition to null
		gameBoard[oldPosition] = null;
		
		// Update the location
		setLocation(newPosition);
	}

}
