package model;

/**
 * The responsibility of RatController is to control its 
 * associated Rat object.
 * 
 * @author ChaTeam
 *
 */
public class RatController {
	
	private Rat rat;
	
	/**
	 * This constructor creates a new Rat object with which
	 * the controller is associated.
	 * 
	 * @param board	This parameter is passed to the constructor 
	 * 				of Rat
	 */
	public RatController(Board board) {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.increaseTab();
		
		this.rat = new Rat(board);
		
		SkeletonDisplay.decreaseTab();
	}

	/**
	 * Returns the Rat controlled by this controller
	 * 
	 * @return Rat controlled by this controller
	 */
	public Rat getPiece() {
		SkeletonDisplay.printMethodName();
		return this.rat;
	}
	
	/**
	 * Calls the methods of the associate Rat object.
	 */
	public void run() {
		SkeletonDisplay.printMethodName();
		SkeletonDisplay.println("In which direction should the rat move?");
		SkeletonDisplay.increaseTab();
		
		rat.moveTo(SkeletonDisplay.readDirection());
		
		SkeletonDisplay.decreaseTab();
	}
}
