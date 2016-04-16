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
	
	/**
	 * This constructor sets the association of the instantiated
	 * Rules object to the input Board parameter.
	 * 
	 * @param board	The Board with which the Rules should be
	 * 				associated
	 */
	public Rules(Board board) {
		SkeletonDisplay.printMethodName();
		this.board = board;
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		EmptyPiece newEmpty = new EmptyPiece();
		newEmpty.setPosition(eaten.getPosition());
		board.switchPieces(eater, newEmpty);
		
		SkeletonDisplay.decreaseTab();
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// move the toPiece THEN the fromPiece (if possible)
		toPiece.moveTo(dir);
		Piece adjacentPiece = this.board.getAdjacentPiece(fromPiece.getPosition(), dir);
		if (adjacentPiece != toPiece) {
			board.switchPieces(fromPiece, adjacentPiece);
		}

		SkeletonDisplay.decreaseTab();
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
		SkeletonDisplay.printMethodName();
		// Lose a life
	}

	/**
	 * Resolves the visit of a Cat by a Cat. No action is taken. 
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toCat		The Visited Piece
	 */
	public void resolve(Cat fromCat, Cat toCat) {
		SkeletonDisplay.printMethodName();
		// Do nothing
	}

	/**
	 * Resolves the visit of a MovableBlock by a Cat. No action is taken.
	 * 
	 * @param fromCat		The Visitor Piece
	 * @param toMovBlock	The Visited Piece
	 */
	public void resolve(Cat fromCat, MovableBlock toMovBlock) {
		SkeletonDisplay.printMethodName();
		// Do nothing		
	}

	/**
	 * Resolves the visit of an ImmovableBlock by a Cat. No action is taken.
	 * 
	 * @param fromCat		The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(Cat fromCat, ImmovableBlock toImmoBlock) {
		SkeletonDisplay.printMethodName();
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// cat moves
		board.switchPieces(fromCat, toEmpty);
		
		SkeletonDisplay.decreaseTab();
	}
	
	/**
	 * Resolves the visit of a Cheese by a Cat. The Cat eats the 
	 * cheese by calling the eat method of Rules.
	 * 
	 * @param fromCat	The Visitor Piece
	 * @param toCheese	The Visited Piece
	 */
	public void resolve(Cat fromCat, Cheese toCheese) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// the cat eats the cheese
		this.eat(fromCat, toCheese);
		
		SkeletonDisplay.decreaseTab();
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
		SkeletonDisplay.printMethodName();
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
		SkeletonDisplay.printMethodName();
		// loose life
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// move the blocks if possible
		this.moveIfPossible(fromRat, toMovBlock, dir);
		
		SkeletonDisplay.decreaseTab();
	}

	/**
	 * Resolves the visit of an ImmovableBlock by a Rat. No action is taken.
	 * 
	 * @param fromRat		The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(Rat fromRat, ImmovableBlock toImmoBlock) {
		SkeletonDisplay.printMethodName();
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// the rat moves
		board.switchPieces(fromRat, toEmpty);
		
		SkeletonDisplay.decreaseTab();
	}

	/**
	 * Resolves the visit of a Cheese by a Rat. The Rat eats the 
	 * cheese by calling the eat method of Rules.
	 * 
	 * @param fromRat	The Visitor Piece
	 * @param toCheese	The Visited Piece
	 */
	public void resolve(Rat fromRat, Cheese toCheese) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// the rat eat the cheese and the player gets points
		this.eat(fromRat, toCheese);
		
		SkeletonDisplay.decreaseTab();
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
		SkeletonDisplay.printMethodName();
		// Do nothing		
	}

	/**
	 * Resolves the visit of a Cat by a MovableBlock. No action is taken.
	 * 
	 * @param fromMovBlock		The Visitor Piece
	 * @param toCat				The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, Cat toCat) {
		SkeletonDisplay.printMethodName();
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.moveIfPossible(fromMovBlock, toMovBlock, dir);
		
		SkeletonDisplay.decreaseTab();
	}
	
	/**
	 * Resolves the visit of an ImmovableBlock by a MovableBlock. No action is taken.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toImmoBlock	The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, ImmovableBlock toImmoBlock) {
		SkeletonDisplay.printMethodName();
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
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// the movable block is moved
		board.switchPieces(fromMovBlock, toEmpty);
		
		SkeletonDisplay.decreaseTab();
	}
	
	/**
	 * Resolves the visit of a Cheese by a MovableBlock. The MovableBlock 
	 * eats the cheese by calling the eat method of Rules.
	 * 
	 * @param fromMovBlock	The Visitor Piece
	 * @param toCheese		The Visited Piece
	 */
	public void resolve(MovableBlock fromMovBlock, Cheese toCheese) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		// movable block is moved and cheese is eaten
		this.eat(fromMovBlock, toCheese);
		
		SkeletonDisplay.decreaseTab();
	}
}