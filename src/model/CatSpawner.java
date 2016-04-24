package model;

/**
 * The CatSpawner is responsible for spawning a new Cat
 * every 60 ticks of the Clock.
 * 
 * @author ChaTeam
 *
 */
public class CatSpawner extends Thread {
	private Initializer init;
	private int startTime;
	private boolean canContinue = false;
	
	private final int SPAWN_TIME = 60;
	/**
	 * This constructor creates a new CatSpawner associated with
	 * the input parameter.
	 * 
	 * @param init	The Initialzer with which the CatSpawner should be associated.
	 */
	public CatSpawner(Initializer init) {
		this.init = init;
	}
	
	/**
	 * Creates a new Cat (and CatController) using the 
	 * associated Initializer when the Clock advances by
	 * more than SPAWN_TIME ticks.
	 */
	public void run() {
		canContinue = true;
		while (canContinue) {
			startTime = Clock.getTime();
			while (Clock.getTime() - startTime < SPAWN_TIME) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			init.initNewCat();
		}
	}
	
	/**
	 * Stops the CatSpawner thread.
	 */
	public void cancel() {
		canContinue = false;
	}
}
