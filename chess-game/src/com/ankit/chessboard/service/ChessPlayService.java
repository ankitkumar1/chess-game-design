package com.ankit.chessboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
					Collectors.joining(", "));
		}
		return "No any possible moves!";
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
		for(int row=0; row<8; row++) {
			for(int col=0; col<8; col++) {
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
