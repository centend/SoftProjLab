package model;

public class TrapBox extends Thread {
	private Rules rules;
	private Cat cat;
	private int startTime;
	private Boolean canContinue = false;
	
	private final int TRAP_TIME = 5;
	
	/**
	 * 
	 * @param rules
	 * @param cat
	 */
	public TrapBox(Rules rules, Cat cat) {
		this.rules = rules;
		this.cat = cat;
	}
	
	/**
	 * 
	 */
	public void run() {
		canContinue = true;
		startTime = Clock.getTime();
		while (canContinue) {
			try {
				Thread.sleep(100);
				if (Clock.getTime() >= startTime + TRAP_TIME) {
					rules.disposeOfBody(this.cat);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

	/**
	 * 
	 */
	public void cancel() {
		canContinue = false;
	}
}
