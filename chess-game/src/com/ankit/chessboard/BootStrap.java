package com.ankit.chessboard;

import com.ankit.chessboard.service.ChessPlayService;

/**
 * Entry point to the project. It will have the main method which will call the required service
 * 
 * @author Ankit
 * @version V1.0
 * */
public class BootStrap {

	public static void main(String[] args) {
		ChessPlayService service = new ChessPlayService();
		String possibleMoves = service.getPossibleMoves("King D5");
		System.out.println(possibleMoves);
		
		String possibleMovesAtBoundry = service.getPossibleMoves("King A3");
		System.out.println(possibleMovesAtBoundry);
		
		String possibleMovesAtCorner = service.getPossibleMoves("King H8");
		System.out.println(possibleMovesAtCorner);

	}
}
