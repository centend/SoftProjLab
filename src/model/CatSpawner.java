package model;

/**
 * 
 * 
 * @author ChaTeam
 *
 */
public class CatSpawner extends Thread {
	private Initializer init;
	private int startTime;
	
	/**
	 * 
	 * @param init
	 */
	public CatSpawner(Initializer init) {
		this.init = init;
	}
	
	/**
	 * 
	 */
	public void run() {
		while (true) {
			startTime = Clock.getTime();
			while (Clock.getTime() - startTime < 60) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			init.initNewCat();
		}
	}
}
