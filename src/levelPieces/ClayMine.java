// Lucas King & Mason Harless
// C07A KerPlop Game

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class ClayMine extends GamePiece {
	// Variable for if the mine is detonated
	boolean detonated = false;
	
	// ClayMine constructor auto-generated
	public ClayMine(char symbol, String name, int location) {
		super(symbol, name, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub

		// If mine is already detonated then it can't blow again
		if (detonated == true) {
			return InteractionResult.NONE;
		}
		
		// If player is on location and it isn't detonated then its a hit
		if (playerLocation == getLocation()) {
			detonated = true;
			return InteractionResult.HIT;
		}
		
		//
		return InteractionResult.NONE;
	}

}
