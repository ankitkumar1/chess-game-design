package com.ankit.chessboard.service;

import java.util.HashSet;
import java.util.Set;

import com.ankit.chessboard.constants.PieceTypeEnum;
import com.ankit.chessboard.model.Cell;
import com.ankit.chessboard.model.ConvertedRequest;
import com.ankit.chessboard.model.pieces.King;
import com.ankit.chessboard.model.pieces.Piece;

/**
 * A validator class to validate the incoming request
 * If request is valid then convert and wrap in ConvertedRequest object.
 * If request is not valid then set error message.
 * 
 * @version 1.1
 * @author Ankit
 * */
public class RequestValidator {

	private final static String INVALID_INPUT_MESSAGE = "It must contain piece type and current position!";
	private final static String INVALID_PIECE_MESSAGE = "Piece is not valid!";
	
	/**
	 * Building this set with fixed set of pices. 
	 * Piece coming in input must be either of these.
	 * */
	private final static Set<String> validPieces = new HashSet<>();
	static {
		validPieces.add(PieceTypeEnum.KING.getValue());
		validPieces.add(PieceTypeEnum.QUEEN.getValue());
		validPieces.add(PieceTypeEnum.BISHOP.getValue());
		validPieces.add(PieceTypeEnum.HORSE.getValue());
		validPieces.add(PieceTypeEnum.ROOK.getValue());
		validPieces.add(PieceTypeEnum.PAWN.getValue());
	}
	
	/**
	 * validate and convert the request in ConvertedRequest object
	 * @param typeAndPosition -> space separated piece and current cell information.
	 * @return ConvertedRequest
	 * */
	public ConvertedRequest validateAndConvert(String typeAndPosition) {
		 
		ConvertedRequest request = new ConvertedRequest();
		// Check for valid input - 1st check.
		if(typeAndPosition==null || typeAndPosition.isEmpty()) {
			request.setErrorMessage("Input is empty. "+INVALID_INPUT_MESSAGE);
			return request;
		}
		
		String[] input = typeAndPosition.split(" ");
		// Check for validity again- 2nd check
		
		if(input.length!=2){
			request.setErrorMessage(INVALID_INPUT_MESSAGE);
			return request;
		}
		
		String pieceType = input[0];
		String stringifiedCell = input[1];
		if(!validPieces.contains(pieceType) || !isValidPosition(stringifiedCell)) {
			request.setErrorMessage(INVALID_PIECE_MESSAGE);
			return request;
		}
		Cell currentCell = Cell.convertToCell(stringifiedCell);
		Piece piece = new King(currentCell);
		request.setCurrentPosition(currentCell);
		request.setPiece(piece);
		
		return request;
	}

	/**
	 * Check for valid position.
	 * y position must be from A to H
	 * x position must be from 1 ot 8
	 * 
	 * @param currentPositionStringified
	 * @return boolean
	 * */
	private boolean isValidPosition(String currentPositionStringified) {
		if(currentPositionStringified.isEmpty() && currentPositionStringified.length()!=2)
			return false;
		
		char yPosition = currentPositionStringified.charAt(0);
		if(yPosition<'A' || yPosition>'H') {
			return false;
		}
		
		String xPosition = currentPositionStringified.substring(1);
		try {
			int x = Integer.parseInt(xPosition);
			if(x<1 || x>8) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
