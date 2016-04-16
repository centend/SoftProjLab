package model;

/**
 * The EmptyPiece class is responsible for interacting with other Piece objects.
 *
 * @author ChaTeam
 *
 */
public class EmptyPiece extends Piece {

	public EmptyPiece() {
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
