package com.ankit.chessboard;

import com.ankit.chessboard.service.ChessPlayService;

/**
 * Entry point to the project. It will have the main method which will call the required service
 * 
 * @author Ankit
 * @version V1.0
 * */
public class BootStrap {

	private static ChessPlayService service = new ChessPlayService();
	
	public static void main(String[] args) {
		
		// Test king moves
		testKingMoves();
		
		// Queen Moves
		testQueenMoves();
		
		// Horse move
		testHorseMoves();
		
		// -ve scenario
		testNegativeScenario();
	}
	
	public static void testKingMoves() {
		String possibleMoves = service.getPossibleMoves("King D5");
		System.out.println("King can move from D5 to -> "+possibleMoves);
		
		String possibleMovesAtBoundry = service.getPossibleMoves("King A3");
		System.out.println("King can move from A3 to -> "+possibleMovesAtBoundry);
		
		String possibleMovesAtCorner = service.getPossibleMoves("King H8");
		System.out.println("King can move from H8 to -> "+possibleMovesAtCorner);
	}
	
	public static void testQueenMoves() {
		String queenMoveH8 = service.getPossibleMoves("Queen H8");
		System.out.println("Queen can move from H8 to -> "+queenMoveH8);
		
		String queenMoveD5 = service.getPossibleMoves("Queen D5");
		System.out.println("Queen can move from D5 to -> "+queenMoveD5);
		
		String queenMoveE1 = service.getPossibleMoves("Queen E1");
		System.out.println("Queen can move from E1 to -> "+queenMoveE1);

	}
	
	public static void testHorseMoves() {
		String h8 = service.getPossibleMoves("Horse H8");
		System.out.println("Horse can move from H8 to -> "+h8);
		
		String d5 = service.getPossibleMoves("Horse D5");
		System.out.println("Horse can move from D5 to -> "+d5);
		
		String e1 = service.getPossibleMoves("Horse E1");
		System.out.println("Horse can move from E1 to -> "+e1);

	}
	
	public static void testNegativeScenario() {
		String emptyInput = service.getPossibleMoves("");
		System.out.println(emptyInput);
		
		String invalidCell = service.getPossibleMoves("King A9");
		System.out.println(invalidCell);
		
		String invalidPiece = service.getPossibleMoves("Kin A6");
		System.out.println(invalidPiece);
	}
}
