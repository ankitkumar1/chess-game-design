package com.ankit.chessboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.constants.ErrorMessage;
import com.ankit.chessboard.model.Cell;
import com.ankit.chessboard.model.ConvertedRequest;
import com.ankit.chessboard.model.pieces.Piece;

/**
 * Service class to perform the actual logic to find all the possible moves
 * for input piece.
 * 
 * @version 1.1
 * @author Ankit
 * */
public class ChessPlayService {

	/**
	 * Fetch all possible moves and convert them to comma separated cell values.
	 * @param typeAndPosition
	 * @return String
	 * */
	public String getPossibleMoves(String typeAndPosition) {
		
		RequestValidator validatorAndConvertor = new RequestValidator();
		ConvertedRequest request = validatorAndConvertor.validateAndConvert(typeAndPosition);
		
		if(request.getErrorMessage()!=null && !request.getErrorMessage().isEmpty()) {
			return request.getErrorMessage();
		}

		List<Cell> allPossibleMoves = this.deriveAllPossibleMoves(request.getPiece(), request.getCurrentPosition());
		if(!allPossibleMoves.isEmpty()) {
			return allPossibleMoves.stream().map(move -> move.stringifiedCell()).collect(
					Collectors.joining(CoreConstants.COMMA_WITH_ONE_SPACE_SEPARATOR));
		}
		return ErrorMessage.NO_ANY_POSSIBLE_MOVES;
	}

	/**
	 * Iterating for all the potential valid cells and identify which are valid move.
	 * 
	 * @param piece
	 * @param currentPosition
	 * @return List<Cell>  list of valid cells.
	 * */
	private List<Cell> deriveAllPossibleMoves(Piece piece, Cell currentPosition) {
		List<Cell> possibleMoves = new ArrayList<>();
		for(int row=CoreConstants.Integer.ZERO; row<CoreConstants.Integer.EIGHT; row++) {
			for(int col=CoreConstants.Integer.ZERO; col<CoreConstants.Integer.EIGHT; col++) {
				Cell destination = new Cell(row, col);
				boolean canMove = piece.canMove(destination);
				if(canMove) {
					possibleMoves.add(destination);
				}
			}
		}
		return possibleMoves;
	}
}
