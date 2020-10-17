package com.ankit.chessboard.model.pieces;

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
		int currentX = currentPosition.getxCord();
		int currentY = currentPosition.getyCord();
		
		int destinationX = destination.getxCord();
		int destinationY = destination.getyCord();
		
		int xDiff = Math.abs(currentX - destinationX);
		int yDiff = Math.abs(currentY - destinationY);
		
		// Check for horizontal and vertical up/down
		if((xDiff==0 && yDiff>0) || (xDiff>0 && yDiff==0)) {
			return true;
		}
		// Check for diagonals
		if(xDiff == yDiff && xDiff>0) {
			return true;
		}
		return false;
	}

}
