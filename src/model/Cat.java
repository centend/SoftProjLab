package model;

/**
 * The Cat class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Cat extends MovablePiece {
	/** 
	 * This constructor calls the constructor of MovablePiece to
	 * set the reference with the board.
	 * 
	 * @param board	The Board with which the Cat should be associated.
	 */
	public Cat(Board board) {
		super(board);
		SkeletonDisplay.printMethodName();
	}
	
	@Override
	public void moveTo(Direction dir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		Piece p = this.board.getAdjacentPiece(this.getPosition(), dir);
		p.accept(this, dir);	
		
		SkeletonDisplay.decreaseTab();
	}	
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		p.visit(this, fromDir);
		
		SkeletonDisplay.decreaseTab();
	}

	@Override
	public void visit(Rat rat, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this,rat);
		
		SkeletonDisplay.decreaseTab();		
	}

	@Override
	public void visit(Cat cat, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this,cat);
		
		SkeletonDisplay.decreaseTab();
	}

	@Override
	public void visit(MovableBlock movBlock, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this, movBlock);
		
		SkeletonDisplay.decreaseTab();
	}

	@Override
	public void visit(ImmovableBlock immoBlock, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this, immoBlock);
		
		SkeletonDisplay.decreaseTab();
	}

	@Override
	public void visit(EmptyPiece empty, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this, empty);	
		
		SkeletonDisplay.decreaseTab();	
	}

	@Override
	public void visit(Cheese cheese, Direction fromDir) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.board.getRules().resolve(this, cheese);	
		
		SkeletonDisplay.decreaseTab();	
	}
}
