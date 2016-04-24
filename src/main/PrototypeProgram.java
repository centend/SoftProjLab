package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;
import view.PrototypeIO;

public class PrototypeProgram {
	private static boolean isDeterministic = true;
	private static Initializer init; 
	
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				PrototypeIO.setFileReader(new FileReader(args[0]));
			} catch (FileNotFoundException e) {
				System.out.println("Invalid file");
				System.exit(-2);
			}
		}
		
		init = new Initializer();
		
		String command = PrototypeIO.getCommand();
		// Process board command first
		if (processCreateBoardCommand(command)) {
			
			// Process other commands
			while (command != null) {
				command = PrototypeIO.getCommand();
				String commandType = command;
				if (command.contains(" ")) {
					commandType = 
							command.substring(0, command.indexOf(' '));
				} 
				switch (commandType) {
					case "move":
						if (!processMoveCommand(command)) {
							PrototypeIO.printInvalidInput(command);
							System.exit(-1);
						}
						break;
					case "tick":
						if (!processAdvanceClockCommmand(command)) {
							PrototypeIO.printInvalidInput(command);
							System.exit(-1);
						}
						break;
					case "exit":
						System.exit(0);
					default:
						PrototypeIO.printInvalidInput(command);
						System.exit(-1);
				}
			}
		} else {
			PrototypeIO.printInvalidInput(command);
			System.exit(-1);
		}
	}
	
	private static boolean processCreateBoardCommand(String command) {
		Pattern p = Pattern.compile("^\\s*board\\((\\d+), (\\d+)\\)( -(r|d))? \"\\[(.*)\\]\"\\s*$");
		Matcher m = p.matcher(command);
		if (m.matches()) {
			// Set determinism flag
			String deterministicFlag = m.group(4);
			if (deterministicFlag != null) {
				switch (deterministicFlag) {
					case "r":
						isDeterministic = false;
						break;
					case "d":
						isDeterministic = true;
						break;
					default:
						return false;
				}
			}
			
			// Create board using parameters
			int rows = Integer.parseInt(m.group(1));
			int cols = Integer.parseInt(m.group(2));
			init.initBoard(rows, cols);
			
			// Put the pieces as described into the board
			int i = 0;
			int j = 0;
			String boardDesciption = m.group(5);
			for (byte symbol : boardDesciption.getBytes()) {
				switch (symbol) {
					case ' ':
						break;
					case ',':
						++j;
						break;
					case ';':
						if (j == cols - 1) {
							j = 0;
							++i;
						} else {
							return false;
						}
						break;
					case 'R':
					case 'C':
					case 'M':
					case 'I':
					case 'E':
					case 'F':
						init.addPiece(symbol, new Position(i, j));
						break;
					default:
						return false;
				}
			}
			if (i == rows - 1) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean processMoveCommand(String command) {
		Pattern p = Pattern.compile("^\\s*move ((rat)|(cat)) (\\d+) (.*)\\s*$");
		Matcher m = p.matcher(command);
		if (m.matches()) {
			String pieceType = m.group(1);
			int id = Integer.parseInt(m.group(4));
			Direction direction = parseDirection(m.group(5));
			if (direction == null) {
				return false;
			}
			
			switch (pieceType) {
				case "rat":
					init.moveRat(id, direction);
					break;
				case "cat":
					init.moveCat(id, direction);
					break;
				default:
					return false;
			}
			return true;
		}
		return false;
	}
	
	private static boolean processAdvanceClockCommmand(String command) {
		Pattern p = Pattern.compile("^\\s*tick( -s (\\d+))?\\s*$");
		Matcher m = p.matcher(command);
		if (m.matches()) {
			String option = m.group(1);
			if (option != null) {
				int ticks = Integer.parseInt(m.group(2));
				Clock.incrementTimeBy(ticks);
			} else {
				Clock.incrementTime();
			}
			return true;
		}
		return false;
	}
	
	private static Direction parseDirection(String dir) {
		switch (dir) {
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
				return null;
		}
	}
	
	public static boolean isDeterministic() {
		return isDeterministic;
	}
	
}
