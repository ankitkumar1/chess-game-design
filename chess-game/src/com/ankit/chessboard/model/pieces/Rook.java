package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.constants.CoreConstants;
import com.ankit.chessboard.model.Cell;

/**
 * Its a subclass of Piece
 * Rook- Can move across the board only vertically and horizontally.
 * 
 * @version 1.0
 * @author Ankit
 * */
public class Rook extends Piece{

	public Rook(Cell currentPosition) {
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
		
		// Moves only vertically and horizontally up/down
		return (xDiff==CoreConstants.Integer.ZERO && yDiff>CoreConstants.Integer.ZERO) || 
				(xDiff>CoreConstants.Integer.ZERO && yDiff==CoreConstants.Integer.ZERO);
	}

}
