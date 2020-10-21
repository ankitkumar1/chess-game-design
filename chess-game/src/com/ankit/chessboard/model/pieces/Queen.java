package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.model.Cell;

/**
 * Its a subclass of Piece
 * Queen- Can move across the board in all 8 directions
 * 
 * @version 1.0
 * @author Ankit
 * */
public class Queen extends Piece{

	public Queen(Cell currentPosition) {
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
		
		// Check for horizontal and vertical up/down
		if((xDiff==CoreConstants.Integer.ZERO && yDiff>CoreConstants.Integer.ZERO) ||
				(xDiff>CoreConstants.Integer.ZERO && yDiff==CoreConstants.Integer.ZERO)) {
			return true;
		}
		// Check for diagonals
		if(xDiff == yDiff && xDiff>CoreConstants.Integer.ZERO) {
			return true;
		}
		return false;
	}

}
