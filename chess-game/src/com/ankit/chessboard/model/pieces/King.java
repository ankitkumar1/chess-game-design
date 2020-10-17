package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.model.Cell;
/**
 * Its a subclass of Piece
 * King- Can move only 1 step at a time in all 8 directions 
 * (horizontal, vertical and diagonal)
 * 
 * @version 1.0
 * @author Ankit
 * */
public class King extends Piece{

	public King(Cell currentPosition) {
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
		if((xDiff==0 && yDiff==1) || (xDiff==1 && yDiff==0)) {
			return true;
		}
		// Check for diagonals
		if(xDiff == yDiff && xDiff==1) {
			return true;
		}
		return false;
	}

}
