package model;

/**
 * The Clock class is a static class responsible for 
 * maintaining the internal clock of the program so 
 * that the events dependent on the clock (methods of 
 * the CatSpawner and TrapBox) can be executed. This 
 * class is static as only a single Clock could be used 
 * in the Prototype and it means that references to it 
 * do not need to be passed to a large number of objects 
 * in the Prototype. It is not required for the Complete 
 * program as that will simply use the real system clock 
 * for scheduling.
 * 
 * @author ChaTeam
 *
 */
public class Clock {
	private static int time = 0;
	
	/**
	 * Returns the current time of Clock
	 * 
	 * @return Current time of Clock
	 */
	public static int getTime() {
		return time;
	}
	
	/**
	 * Increases the value of the time attribute by one.
	 */
	public static void incrementTime() {
		time += 1;
	}
	
	/**
	 * Increases the value of the time attribute by
	 * the input parameter (must be positive or no change is
	 * made.
	 * 
	 * @param ticks The number of units the time should 
	 * 					be incremented by 
	 */
	public static void incrementTimeBy(int ticks) {
		if (ticks > 0) {
			time += ticks;
		}
	}
	
	/**
	 * Resets the value of the time attribute to zero.
	 */
	public void resetTime() {
		time = 0;
	}
}
