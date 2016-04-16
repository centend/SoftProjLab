package model;

import java.util.ArrayList;

/**
 * The Initializer is responsible for initializing all the 
 * various components of the game.
 * 
 * @author ChaTeam
 *
 */
public class Initializer 
{
	private Board board;
	private RatController ratController;
	private ArrayList<CatController> catControllers = new ArrayList<>();
	
	/**
	 * Initializes the objects required for Use-Case 1, where a Rat moves to
	 * the right to a cell containing a Rat.
	 */
	public void useCase1() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 1: R - R");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);
		RatController ratController2 = new RatController(board);
		
		board.putPieceAt(ratController.getPiece(), new Position(0, 0));
		board.putPieceAt(ratController2.getPiece(), new Position(0, 1));
		
		ratController.run();
	}
	
	/**
	 * Initializes the objects required for Use-Case 2, where a Rat moves to
	 * the right to a cell containing a Cat.
	 */
	public void useCase2() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 2: R - C");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(catController.getPiece(), new Position(0,1));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 3, where a Rat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing a Rat.
	 */
	public void useCase3() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 3: R - M - R");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		ratController = new RatController(board);
		RatController ratController2 = new RatController(board);
		
		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new MovableBlock(board), new Position(0,1));
		board.putPieceAt(ratController2.getPiece(), new Position(0,2));
		
		ratController.run();	
	}

	/**
	 * Initializes the objects required for Use-Case 4, where a Rat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing a Cat.
	 */
	public void useCase4() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 4: R - M - C");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		ratController = new RatController(board);
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new MovableBlock(board), new Position(0,1));
		board.putPieceAt(catController.getPiece(), new Position(0,2));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 5, where a Rat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing an EmptyPiece.
	 */
	public void useCase5() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 5: R - M - E");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		ratController = new RatController(board);
		
		board.putPieceAt(ratController.getPiece(), new Position(0, 0));
		board.putPieceAt(new MovableBlock(board), new Position(0, 1));
		board.putPieceAt(new EmptyPiece(), new Position(0, 2));
		
		ratController.run();	
	}

	/**
	 * Initializes the objects required for Use-Case 6, where a Rat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing an ImmovableBlock.
	 */
	public void useCase6() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 6: R - M - I");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		ratController = new RatController(board);

		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new MovableBlock(board), new Position(0,1));
		board.putPieceAt(new ImmovableBlock(), new Position(0,2));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 7, where a Rat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing a Cheese.
	 */
	public void useCase7() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 7: R - M - F");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		ratController = new RatController(board);

		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new MovableBlock(board), new Position(0,1));
		board.putPieceAt(new Cheese(), new Position(0,2));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 8, where a Rat moves to
	 * the right to a cell containing an ImmovableBlock.
	 */
	public void useCase8() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 8: R - I");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);

		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new ImmovableBlock(), new Position(0,1));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 9, where a Rat moves to
	 * the right to a cell containing an EmptyPiece.
	 */
	public void useCase9() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 9: R - E");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);

		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new EmptyPiece(), new Position(0,1));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 10, where a Rat moves to
	 * the right to a cell containing a Cheese.
	 */
	public void useCase10() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 10: R - F");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);

		board.putPieceAt(ratController.getPiece(), new Position(0,0));
		board.putPieceAt(new Cheese(), new Position(0,1));
		
		ratController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 11, where a Cat moves to
	 * the right to a cell containing a Rat.
	 */
	public void useCase11() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 11: C - R");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		ratController = new RatController(board);
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(catController.getPiece(), new Position(0,0));
		board.putPieceAt(ratController.getPiece(), new Position(0,1));
		
		catController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 12, where a Cat moves to
	 * the right to a cell containing a Cat.
	 */
	public void useCase12() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 12: C - C");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		catControllers.add(new CatController(board));
		catControllers.add(new CatController(board));
		
		board.putPieceAt(catControllers.get(0).getPiece(), new Position(0,0));
		board.putPieceAt(catControllers.get(1).getPiece(), new Position(0,1));
		
		catControllers.get(0).run();
	}

	/**
	 * Initializes the objects required for Use-Case 13, where a Cat moves to
	 * the right to a cell containing a MovableBlock, followed by a cell 
	 * containing an EmptyPiece.
	 */
	public void useCase13() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 13: C - M - E");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 3);
		
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(catController.getPiece(), new Position(0,0));
		board.putPieceAt(new MovableBlock(board), new Position(0,1));
		board.putPieceAt(new EmptyPiece(), new Position(0,1));
		
		catController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 14, where a Cat moves to
	 * the right to a cell containing an ImmovableBlock.
	 */
	public void useCase14() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 14: C - I");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(catController.getPiece(), new Position(0,0));
		board.putPieceAt(new ImmovableBlock(), new Position(0,1));
		
		catController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 15, where a Cat moves to
	 * the right to a cell containing an EmptyPiece.
	 */
	public void useCase15() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 15: C - E");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		CatController catController = new CatController(board);
		catControllers.add(catController);
		
		board.putPieceAt(catController.getPiece(), new Position(0,0));
		board.putPieceAt(new EmptyPiece(), new Position(0,1));
		
		catController.run();
	}

	/**
	 * Initializes the objects required for Use-Case 16, where a Cat moves to
	 * the right to a cell containing a Cheese.
	 */
	public void useCase16() {
		SkeletonDisplay.resetTab();
		SkeletonDisplay.println("Use-Case 16: C - F");
		SkeletonDisplay.increaseTab();
		
		board = new Board(1, 2);
		
		CatController catController = new CatController(board);
		catControllers.add(catController);
	
		board.putPieceAt(catController.getPiece(), new Position(0,0));
		board.putPieceAt(new Cheese(), new Position(0,1));
		
		catController.run();
	}
}
