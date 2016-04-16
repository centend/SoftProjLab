package model;

/**
 * The ImmovableBlock class is responsible for interacting with 
 * other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class ImmovableBlock extends Piece {

	public ImmovableBlock() {
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
