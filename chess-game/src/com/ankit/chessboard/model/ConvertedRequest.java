package com.ankit.chessboard.model;

import com.ankit.chessboard.model.pieces.Piece;

/**
 * Class to store converted request
 * Conversion is done from String input to converted Cell and Piece object
 *
 * @version V1.0
 * @author Ankit
 * */

public class ConvertedRequest {

	/**
	 * Error Message to store error if input is not valid.
	 * */
	private String errorMessage;
	
	/**
	 * Cell object to represent the current position.
	 * */
	private Cell currentPosition;
	
	/**
	 * Specific piece extracted from input string.
	 * */
	private Piece piece;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Cell getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Cell currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
