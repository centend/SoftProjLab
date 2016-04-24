package model;

import java.util.ArrayList;

/**
 * The Initializer is responsible for initializing all the 
 * various components of the game.
 * 
 * @author ChaTeam
 *
 */
public class Initializer {
	private Board board;
	private RatController ratController;
	private ArrayList<CatController> catControllers = new ArrayList<>();
	private CatSpawner catSpawner;
	
	public Initializer() {}
	
	public void initBoard(int rows, int cols) {
		board = new Board(rows, cols);
		this.ratController = new RatController(board);
		this.catSpawner = new CatSpawner(this);
		this.catSpawner.start();
	}
	
	public void initNewCat() {
		CatController newCatController = new CatController(board);
		board.putCatAtRandomEmptyPos(newCatController.getPiece());
		catControllers.add(newCatController);
		newCatController.start();
	}
	
	public void moveRat(int id, Direction dir) {
		ratController.moveRat(dir);
	}
	
	public void moveCat(int id, Direction dir) {
		catControllers.get(id - 1).moveCat(dir);
	}

	public void resetBoard() {
		// TODO Auto-generated method stub
	}

	public void gameOver() {
		catSpawner.cancel();
		for (CatController catController : catControllers) {
			catController.getPiece().releaseTrapBox();
			catController.cancel();
		}
	}

	public void stopCatController(Cat deadCat) {
		catControllers.get(catControllers.indexOf(deadCat)).cancel();
	}
}
