package model;

/**
 * The Board is responsible for maintaining the spatial layout of 
 * the game and resolving conflicts between Pieces through the Rules 
 * class. Ton maintaining the spatial layout of the game board, the 
 * Board has references to all the Pieces and can move pieces.
 * 
 * @author ChaTeam
 *
 */
public class Board {
	private int rows;
	private int cols;
	
	private Piece[][] cells;
	private Rules rules;
	
	/** 
	 * The constructor for the Board creates a two-dimensional array
	 * of Pieces of size rows by cols. It also creates and stores a 
	 * reference to the Rules object.
	 * 
	 * @param rows	The number of rows the board should have
	 * @param cols	The number of columns the board should have
	 */
	public Board(int rows, int cols) {
		SkeletonDisplay.printMethodName();
		
		this.rows = rows;
		this.cols = cols;
		this.cells = new Piece[rows][cols];
		this.rules = new Rules(this);
//		this.cats = new ArrayList<Cat>();
	}
	
	/** 
	 * Returns a reference to the Rules object of the Board.
	 * 
	 * @return Reference to the Rules object of the Board
	 */
	public Rules getRules() {
		SkeletonDisplay.printMethodName();
		return this.rules;
	}
	
	/**
	 * Puts the input piece at the given position. This method does not check
	 * for any conflicts.
	 * 
	 * @param piece	The Piece to be moved.
	 * @param pos	The desired Position of the Piece to be moved.
	 */
	public void putPieceAt(Piece piece, Position pos) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.cells[pos.getRow()][pos.getColumn()] = piece;
		piece.setPosition(pos);
		
		SkeletonDisplay.decreaseTab();
	}
		
	/**
	 * Return the piece adjacent to the cell defined by the Position 
	 * parameter in the given direction
	 * 
	 * @param pos	The Position of the Piece for which you want the
	 * 				adjacent piece
	 * @param dir	The direction of the edge with which the desired 
	 * 				Piece is adjacent with the cell defined by the pos 
	 * 				parameter
	 * @return		The adjacent Piece in the specified Direction. Returns
	 * 				an ImmovableBlock in the case that the Position and
	 * 				given Direction are invalid. 
	 */
	public Piece getAdjacentPiece(Position pos, Direction dir) {
		SkeletonDisplay.printMethodName();
		int dir_row = 0, dir_col = 0;
		switch (dir) {
			case UP:
				dir_row = 1;
				break;
			case DOWN:
				dir_row = -1;
				break;
			case LEFT:
				dir_col = -1;
				break;
			case RIGHT:
				dir_col = 1;
				break;
			case UPPER_LEFT:
				dir_col = -1;
				dir_row = 1;
				break;
			case UPPER_RIGHT:
				dir_col = 1;
				dir_row = 1;
				break;
			case LOWER_LEFT:
				dir_col = -1;
				dir_row = -1;
				break;
			case LOWER_RIGHT:
				dir_col = 1;
				dir_row = -1;
				break;
		}
		int adjacentCellRow = pos.getRow() + dir_row;
		int adjacentCellColumn = pos.getColumn() + dir_col;
		
		if (adjacentCellRow >= 0 && adjacentCellColumn >= 0 
				&& adjacentCellRow < rows && adjacentCellColumn < cols) {
			return cells[adjacentCellRow][adjacentCellColumn];
		}
		return new ImmovableBlock();
	}
	
	/**
	 * Switches the position of two input Pieces on the board
	 * 
	 * @param p1	The first Piece.
	 * @param p2	The second Piece.
	 */
	// switch the two pieces on the board
	public void switchPieces(Piece p1, Piece p2) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		Position pos1 = p1.getPosition();
		Position pos2 = p2.getPosition();
		
		this.putPieceAt(p1, pos2);
		this.putPieceAt(p2, pos1);
		
		SkeletonDisplay.decreaseTab();
	}
}
