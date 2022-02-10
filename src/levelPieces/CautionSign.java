// Lucas King & Mason Harless
// C07A KerPlop Game

package levelPieces;
import gameEngine.Drawable;

public class CautionSign implements Drawable {
	char character;

	public CautionSign() {
		super();
		// TODO Auto-generated constructor stub
		character = '!';
	}
	
	@Override
	public void draw() {
		// Use print instead of println for the appearance
		System.out.print(character);
	}
}
