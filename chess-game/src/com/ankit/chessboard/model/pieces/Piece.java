package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.model.Cell;

/**
 * Abstract class parent to all the pieces
 *
 * @version V1.0
 * @author Ankit
 * */
public abstract class Piece {

	/*
	 * Variable to store current position of the piece.
	 * */
	protected Cell currentPosition;
	
	public Piece(Cell currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	/**
	 * Method to check is the piece can move from the current position to destination
	 * 
	 * @param destination
	 * */
	public abstract boolean canMove(Cell destination);
	
}
