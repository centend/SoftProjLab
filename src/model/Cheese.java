package model;

/**
 * The Cheese class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Cheese extends Piece {

	public Cheese() {}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {		
		p.visit(this, fromDir);
	}

	@Override
	public String getSymbol() {
		return "F";
	}
}
