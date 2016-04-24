package model;

/**
 * The Rules class is responsible for resolving conflicts between 
 * the different Pieces. This class is considered necessary so that 
 * all the rules of the game are containing in one place.
 * 
 * @author ChaTeam
 *
 */
public class Rules {
	
	private Board board;
	private PlayerStats playerStats;
	private Initializer init;
	
	private final int CHEESE_POINTS = 10;
	
	/**
	 * This constructor sets the association of the instantiated
	 * Rules object to the input Board parameter.
	 * 
	 * @param board	The Board with which the Rules should be
	 * 				associated
	 */
	public Rules(Board board) {
		this.board = board;
		this.playerStats = new PlayerStats(1);
	}
	
	/**
	 * 
	 * @return
	 */
	public PlayerStats getStats() {
		return playerStats;
	}
	
	/**
	 * This method is used when a Piece "eats" another Piece according
	 * to the rules of the Game. The eaten Piece is replaced by an 
	 * EmptyPiece. The eater Piece and the new EmptyPiece switch places.
	 * 
	 * @param eater	The Piece the will eat
	 * @param eaten	The Piece to be remove and replaced by an EmptyPiece
	 */
	// the 'eater' piece eats the 'eaten' piece
	private void eat(Piece eater, Piece eaten) {
		EmptyPiece newEmpty = new EmptyPiece();
		newEmpty.setPosition(eaten.getPosition());
		board.switchPieces(eater, newEmpty);
	}

	/**
	 * If possible, recursively moves the Pieces in the supplied direction.
	 * 
	 * @param fromPiece	The Visitor Piece
	 * @param toPiece	The Visited Piece
	 * @param dir		The direction of movement from the perspective of 
	 * 					the Visitor Piece
	 */
	private void moveIfPossible(MovablePiece fromPiece, MovablePiece toPiece, Direction dir) {
		// move the toPiece THEN the fromPiece (if possible)
		toPiece.moveTo(dir);
		Piece adjacentPiece = this.board.getAdjacentPiece(fromPiece.getPosition(), dir);
		if (adjacentPiece != toPiece) {
			board.switchPieces(fromPiece, adjacentPiece);
		}
	}
	
	/**
	 * 
	 */
	private void playerLosesLife() {
		playerStats.loseLife();
		if (playerStats.canContinue()) {
			init.resetBoard();
		} else {
			init.gameOver();
		}
	}
	
	
	// Rules of the Game
	// -------------------------
	// Rules for Cats
	/**
	 * Resolves the visit of a Rat by a Cat. The Player should lose
	 * a life (not implemented in the Skeleton).
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toRat		The Visited Piece
	 */
	public void resolve(Cat fromCat, Rat toRat) {
		playerLosesLife();
	}

	/**
	 * Resolves the visit of a Cat by a Cat. No action is taken. 
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toCat		The Visited Piece
	 */
	public void resolve(Cat fromCat, Cat toCat) {
		// Do nothing
	}

	/**
	 * Resolves the visit of a MovableBlock by a Cat. No action is taken.
	 * 
	 * @param fromCat		The Visitor Piece
	 * @param toMovBlock	The Visited Piece
	 */
	public void resolve(Cat fromCat, MovableBlock toMovBlock) {
		// Do nothing		
	}

	/**
	 * Resolves the visit of an ImmovableBlock by a Cat. No action is taken.
	 * 
	 * @param fromCat		The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(Cat fromCat, ImmovableBlock toImmoBlock) {
		// Do nothing
	}
	
	/**
	 * Resolves the visit of an EmptyPiece by a Cat. The EmptyPiece and the Cat
	 * switch places using the switchPieces method of the board.
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toEmpty	The Visited Piece
	 */
	public void resolve(Cat fromCat, EmptyPiece toEmpty) {
		// cat moves
		board.switchPieces(fromCat, toEmpty);
	}
	
	/**
	 * Resolves the visit of a Cheese by a Cat. The Cat eats the 
	 * cheese by calling the eat method of Rules.
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toCheese	The Visited Piece
	 */
	public void resolve(Cat fromCat, Cheese toCheese) {
		// the cat eats the cheese
		this.eat(fromCat, toCheese);
	}
	
	
	// -------------------------
	// Rules for Rats	
	/**
	 * Resolves the visit of a Rat by a Rat. No action is taken.
	 * 
	 * @param fromRat	The Visitor Piece
	 * @param toRat		The Visited Piece
	 */
	public void resolve(Rat fromRat, Rat toRat) {
		// Do nothing		
	}
	
	/**
	 * Resolves the visit of a Cat by a Rat. The Player should lose
	 * a life (not implemented in the Skeleton).
	 * 
	 * @param fromRat	The Visitor Piece
	 * @param toCat		The Visited Piece
	 */
	public void resolve(Rat fromRat, Cat toCat) {
		playerLosesLife();
	}
	
	/**
	 * Resolves the visit of a MovableBlock by a Rat. Calls the moveIfPossible
	 * method using the input parameters.
	 * 
	 * @param fromRat		The Visitor Piece
	 * @param toMovBlock	The Visited Piece
	 * @param dir			The direction from which the fromRat is
	 * 						approaching the toMovBlock from the perspective
	 * 						of the fromRat
	 */
	public void resolve(Rat fromRat, MovableBlock toMovBlock, Direction dir) {
		// move the blocks if possible
		this.moveIfPossible(fromRat, toMovBlock, dir);
	}

	/**
	 * Resolves the visit of an ImmovableBlock by a Rat. No action is taken.
	 * 
	 * @param fromRat		The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(Rat fromRat, ImmovableBlock toImmoBlock) {
		// Do nothing
	}
	
	/**
	 * Resolves the visit of an EmptyPiece by a Rat. The EmptyPiece and the Rat
	 * switch places using the switchPieces method of the board.
	 * 
	 * @param fromRat	The Visitor Piece
	 * @param toEmpty	The Visited Piece
	 */
	public void resolve(Rat fromRat, EmptyPiece toEmpty) {
		// the rat moves
		board.switchPieces(fromRat, toEmpty);
	}

	/**
	 * Resolves the visit of a Cheese by a Rat. The Rat eats the 
	 * cheese by calling the eat method of Rules.
	 * 
	 * @param fromRat	The Visitor Piece
	 * @param toCheese	The Visited Piece
	 */
	public void resolve(Rat fromRat, Cheese toCheese) {
		playerStats.addPoints(CHEESE_POINTS);
		this.eat(fromRat, toCheese);
	}

	
	// -------------------------
	// Rules for MovableBlocks
	/**
	 * Resolves the visit of a Rat by a MovableBlock. No action is taken.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toRat			The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, Rat toRat) {
		// Do nothing		
	}

	/**
	 * Resolves the visit of a Cat by a MovableBlock. No action is taken.
	 * 
	 * @param fromMovBlock		The Visitor Piece
	 * @param toCat				The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, Cat toCat) {
		// Do nothing
	}
	
	/**
	 * Resolves the visit of a MovableBlock by a MovableBlock. Calls the moveIfPossible
	 * method using the input parameters.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toMovBlock	The Visited Piece
	 * @param dir			The direction from which the fromMovBlock is
	 * 						approaching the toMovBlock from the perspective
	 * 						of the fromRat
	 */
	public void resolve(MovableBlock fromMovBlock, MovableBlock toMovBlock, Direction dir) {
		this.moveIfPossible(fromMovBlock, toMovBlock, dir);
	}
	
	/**
	 * Resolves the visit of an ImmovableBlock by a MovableBlock. No action is taken.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, ImmovableBlock toImmoBlock) {
		// Do nothing
	}
	
	/**
	 * Resolves the visit of an EmptyPiece by a MovableBlock. The EmptyPiece and 
	 * the MovableBlock switch places using the switchPieces method of the board.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toEmpty		The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, EmptyPiece toEmpty) {
		// the movable block is moved
		board.switchPieces(fromMovBlock, toEmpty);
	}
	
	/**
	 * Resolves the visit of a Cheese by a MovableBlock. The MovableBlock 
	 * eats the cheese by calling the eat method of Rules.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toCheese		The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, Cheese toCheese) {
		playerStats.addPoints(CHEESE_POINTS);
		this.eat(fromMovBlock, toCheese);
	}

	/**
	 * 
	 * @param cat
	 * @param trapped
	 */
	public void updateTrappedCat(Cat cat, boolean trapped) {
		if (trapped) {
			cat.getTrapBox();
		} else {
			cat.releaseTrapBox();
		}
	}
	
	public void disposeOfBody(Cat deadCat) {
		board.putPieceAt(new Cheese(), deadCat.getPosition());
		init.stopCatController(deadCat);
	}
}