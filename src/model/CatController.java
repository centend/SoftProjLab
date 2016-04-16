package model;

/**
 * The responsibility of CatController is to control its 
 * associated Cat object.
 * 
 * @author ChaTeam
 *
 */
public class CatController {
	private Cat cat;
	
	/**
	 * This constructor creates a new Cat object with which
	 * the controller is associated.
	 * 
	 * @param board	This parameter is passed to the constructor 
	 * 				of Cat
	 */
	public CatController(Board board) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.cat = new Cat(board);
		
		SkeletonDisplay.decreaseTab();
	}

	/**
	 * Returns the Cat controlled by this controller
	 * 
	 * @return Cat controlled by this controller
	 */
	public Cat getPiece() {
		SkeletonDisplay.printMethodName();
		
		return this.cat;
	}
	
	/**
	 * Calls the methods of the associated Cat object.
	 */
	public void run() {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.println("In which direction should the cat move?");
		SkeletonDisplay.increaseTab();
		
		cat.moveTo(SkeletonDisplay.readDirection());
		
		SkeletonDisplay.decreaseTab();
	}
}
