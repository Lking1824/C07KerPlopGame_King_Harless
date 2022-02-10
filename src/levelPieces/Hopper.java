package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Hopper extends GamePiece implements Moveable {
	// Create a way to detect direction of movement
	// 1 = right, 0 = left
	int whichWay = 1;
		
	public Hopper(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if ((playerLocation == (getLocation()) - 1) || (playerLocation == (getLocation()) + 1)) {
			return InteractionResult.KILL;
		}
		
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// If at left most location move right
		if ((getLocation() == 0) || (getLocation() == 1)) {
			whichWay = 1;
		}
		
		// If at right most location move left
		if ((getLocation() == (GameEngine.BOARD_SIZE - 1)) || (getLocation() == (GameEngine.BOARD_SIZE - 2))) {
			whichWay = 0;
		}
		
		// Moving left and next location is empty
		if ((whichWay == 0) && (gameBoard[getLocation() - 1] == null)) {
			// Update previous location
			int previousLoc = getLocation();
			// Set current location
			setLocation(getLocation() - 2);
			
			// Update the game board
			gameBoard[getLocation()] = gameBoard[previousLoc];
			gameBoard[previousLoc] = null;			
		}
		// Moving left and next location is not empty
		else if ((whichWay == 0) && (gameBoard[getLocation() - 2] != null)) {
			// Current location variable
			int currentLoc = getLocation();
			// Create dummy location
			int dummyLoc = getLocation() - 2;
			
			// Loop until there is an empty location
			while (gameBoard[dummyLoc] != null && dummyLoc > 1) {
				// Decrement dummy location
				dummyLoc = dummyLoc - 2;
			}
			
			// If dummy is less than 0, set whichWay to right
			if (dummyLoc <= 1) {
				whichWay = 1;
			}
			else {
				// Set location
				setLocation(dummyLoc);
				
				// Update the gameBoard
				gameBoard[dummyLoc] = gameBoard[currentLoc];
				gameBoard[currentLoc] = null;
			}
		}
		
		// If moving right and next location is empty
		if ((whichWay == 1) && (gameBoard[getLocation() + 2] == null)) {
			// Update previous location
			int previousLoc = getLocation();
			// Set current location
			setLocation(getLocation() + 2);
			
			// Update the game board
			gameBoard[getLocation()] = gameBoard[previousLoc];
			gameBoard[previousLoc] = null;			
		}
		// if moving right and next location isn't empty
		else if ((whichWay == 1) && (gameBoard[getLocation() + 2] != null)) {
			// Current location variable
			int currentLoc = getLocation();
			// Create dummy location
			int dummyLoc = getLocation() + 2;
			
			// Loop until there is an empty location
			while (gameBoard[dummyLoc] != null && (dummyLoc < (GameEngine.BOARD_SIZE - 2))) {
				// Decrement dummy location
				dummyLoc = dummyLoc + 2;
//				System.out.println("Dummy location is:" + dummyLoc);
			}
			
			// If dummy is less than 0, set whichWay to right
			if (dummyLoc >= (GameEngine.BOARD_SIZE - 2)) {
				whichWay = 0;
			}
			else {
				// Set location
				setLocation(dummyLoc);
				
				// Update the gameBoard
				gameBoard[dummyLoc] = gameBoard[currentLoc];
				gameBoard[currentLoc] = null;
			}
		}
		
		
	}

}
