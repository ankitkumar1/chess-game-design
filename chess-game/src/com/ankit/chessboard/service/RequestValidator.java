package com.ankit.chessboard.service;

import java.util.HashSet;
import java.util.Set;

import com.ankit.chessboard.PieceFactory;
import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.constants.ErrorMessage;
import com.ankit.chessboard.constants.PieceTypeEnum;
import com.ankit.chessboard.model.Cell;
import com.ankit.chessboard.model.ConvertedRequest;
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
			request.setErrorMessage(ErrorMessage.EMPTY_INPUT);
			return request;
		}
		
		String[] input = typeAndPosition.split(CoreConstants.SPACE);
		// Check for validity again- 2nd check
		
		if(input.length != CoreConstants.Integer.TWO){
			request.setErrorMessage(ErrorMessage.INVALID_INPUT_MESSAGE);
			return request;
		}
		
		String pieceTypeValue = input[CoreConstants.Integer.ZERO];
		String stringifiedCell = input[CoreConstants.Integer.ONE];
		if(!validPieces.contains(pieceTypeValue) || !isValidPosition(stringifiedCell)) {
			request.setErrorMessage(ErrorMessage.INVALID_PIECE_OR_CELL_MESSAGE);
			return request;
		}
		Cell currentCell = Cell.convertToCell(stringifiedCell);
		
		// Calling factory class for building instances of different piece based on input.
		PieceFactory pieceFactory = new PieceFactory();
		Piece piece = pieceFactory.buildPiece(pieceTypeValue, currentCell);
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
		if(currentPositionStringified.isEmpty() && 
				currentPositionStringified.length()!=CoreConstants.Integer.TWO)
			return false;
		
		char column = currentPositionStringified.charAt(CoreConstants.Integer.ZERO);
		if(column<CoreConstants.Alphabet.A_CAPS || column>CoreConstants.Alphabet.H_CAPS) {
			return false;
		}
		
		String rowNumString = currentPositionStringified.substring(CoreConstants.Integer.ONE);
		try {
			int row = Integer.parseInt(rowNumString);
			if(row<CoreConstants.Integer.ONE || row>CoreConstants.Integer.EIGHT) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
