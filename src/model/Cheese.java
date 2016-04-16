package model;

/**
 * The Cheese class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Cheese extends Piece {

	public Cheese() {
		SkeletonDisplay.printMethodName();
	}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		p.visit(this, fromDir);
		
		SkeletonDisplay.decreaseTab();
	}

}
