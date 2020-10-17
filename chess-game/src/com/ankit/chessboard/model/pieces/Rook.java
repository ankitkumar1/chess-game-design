package com.ankit.chessboard.model.pieces;

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
		int currentX = currentPosition.getxCord();
		int currentY = currentPosition.getyCord();
		
		int destinationX = destination.getxCord();
		int destinationY = destination.getyCord();
		
		int xDiff = Math.abs(currentX - destinationX);
		int yDiff = Math.abs(currentY - destinationY);
		
		// Moves only vertically and horizontally up/down
		return (xDiff==0 && yDiff>0) || (xDiff>0 && yDiff==0);
	}

}
