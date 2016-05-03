package model;

/**
 * The ImmovableBlock class is responsible for interacting with 
 * other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class ImmovableBlock extends Piece {

	public ImmovableBlock() {}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		p.visit(this, fromDir);
	}
	
	@Override
	public String getSymbol() {
		return "I";
	}
}
