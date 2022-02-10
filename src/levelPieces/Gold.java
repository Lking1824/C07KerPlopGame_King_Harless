// Lucas King & Mason Harless
// C07A KerPlop Game

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Gold extends GamePiece {
	// Create variable to see if the gold has been found
	// 0 for not found, 1 for found
	int found = 0;
	
	
	public Gold(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
		// If gold has already been found then there is no interaction
		if (found == 1) {
			return InteractionResult.NONE;
		}
		
		// If gold hasn't been found and player is at same location then they get a point
		if (playerLocation == getLocation()) {
			found = 1;
			return InteractionResult.GET_POINT;
		}
		
		// If gold hasn't been found but player isn't at same location there is no interaction
		return InteractionResult.NONE;
	}

}
