package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.model.Cell;

/**
 * Its a subclass of Piece
 * Bishop- Can move across the board only diagonally.
 * 
 * @version 1.0
 * @author Ankit
 * */
public class Bishop extends Piece{

	public Bishop(Cell currentPosition) {
		super(currentPosition);
	}

	@Override
	public boolean canMove(Cell destination) {
		int currentX = currentPosition.getRow();
		int currentY = currentPosition.getCol();
		
		int destinationX = destination.getRow();
		int destinationY = destination.getCol();
		
		int xDiff = Math.abs(currentX - destinationX);
		int yDiff = Math.abs(currentY - destinationY);
		
		// Moves only diagonally
		return xDiff == yDiff && xDiff > CoreConstants.Integer.ZERO;
	}

}
