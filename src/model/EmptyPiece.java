package model;

/**
 * The EmptyPiece class is responsible for interacting with other Piece objects.
 *
 * @author ChaTeam
 *
 */
public class EmptyPiece extends Piece {

	public EmptyPiece() {}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		p.visit(this, fromDir);
	}


}
