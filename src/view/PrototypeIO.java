package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;

public class PrototypeIO {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String getCommand() {
		try {
			String command = br.readLine();
			return command;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void printSwitch(Piece p1, Piece p2) {
		
	}
	
	public static void printCatSpawn(Cat cat, int id) {
		
	}
	
	public static void printRatDies(Rat rat, int id) {
		
	}
	
	public static void printCatDies(Cat cat, int id) {
		
	}
	
	public static void printCreatedReplaces(Piece p1, Piece p2) {
		
	}
	
	public static void printScore() {
		
	}
	
	public static void printLives() {
		
	}

	public static void gameOeer() {
	
	}
}
