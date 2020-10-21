package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.model.Cell;

/**
 * Its a subclass of Piece
 * Horse- Can move across the board only in 2.5 steps (2 vertical steps and 1 horizontal step)
 * 
 * @version 1.0
 * @author Ankit
 * */
public class Horse extends Piece{

	public Horse(Cell currentPosition) {
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
		
		// Moves 2.5
		return (xDiff==CoreConstants.Integer.ONE && yDiff==CoreConstants.Integer.TWO) || 
				(xDiff==CoreConstants.Integer.TWO && yDiff==CoreConstants.Integer.ONE);
	}
}
