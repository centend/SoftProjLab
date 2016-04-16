package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The SkeletonDisplay is a static class used for reading and writing to 
 * the console for the purposes of the Skeleton Program. The most 
 * important feature is the maintaining of the tabulator state so that
 * following the method calls of the Skeleton is more logical. 
 * 
 * @author ChaTeam
 *
 */
public class SkeletonDisplay {
	private static String tab = "";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Resets the tabulator to be empty.
	 */
	public static void resetTab() {
		tab = "";
	}
	
	/**
	 * Increases the tabulator by two spaces.
	 */
	public static void increaseTab() {
		tab += "  ";
	}
	
	/**
	 * Decreases the tabulator by two spaces. Checks if the tabulator 
	 * has two spaces before decrementing. 
	 */
	public static void decreaseTab() {
		if (tab.length() >= 2) {
			tab = tab.substring(2);
		}
	}
	
	/**
	 * Prints the input to the console without appending a newline character.
	 * 
	 * @param str	The string to be printed to the console
	 */
	public static void print(String str) {
		System.out.print(tab + str);
	}
	
	/**
	 * Prints the input to the console and appends a newline character.
	 * 
	 * @param str	The string to be printed to the console
	 */
	public static void println(String str) {
		System.out.println(tab + str);
	}
	
	/**
	 * Prints the method name of the method calling this method. The class
	 * of the method, its name, and the line number of the method are printed. 
	 */
	public static void printMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String longMethod = stackTrace[2].toString();
		SkeletonDisplay.println(longMethod.substring(longMethod.indexOf('.') + 1));
	}
	
	/** 
	 * Reads a line from the console. Places a '$' as the prompt for the user.
	 * 
	 * @return The line read from the console.
	 */
	public static String readLine() {
		try {
			print("$ ");
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}
	
	/**
	 * Reads a Direction from the console. Does not return until a
	 * recognized direction has been read.
	 * 
	 * @return	Direction from the console.
	 */
	public static Direction readDirection() {
		switch (readLine().toLowerCase()) {
			case "u":
			case "up":
				return Direction.UP;
			case "d":
			case "down":
				return Direction.DOWN;
			case "l":
			case "left":
				return Direction.LEFT;
			case "r":
			case "right":
				return Direction.RIGHT;
			case "ul":
			case "upperleft":
				return Direction.UPPER_LEFT;
			case "ur":
			case "upperright":
				return Direction.UPPER_RIGHT;
			case "ll":
			case "lowerleft":
				return Direction.LOWER_LEFT;
			case "lr":
			case "lowerright":
				return Direction.LOWER_RIGHT;
			default:
				println("Incorrect direction, try again");
				return readDirection();
		}
	}
}
