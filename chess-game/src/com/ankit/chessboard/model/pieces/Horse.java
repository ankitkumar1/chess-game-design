package com.ankit.chessboard.model.pieces;

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
		int currentX = currentPosition.getxCord();
		int currentY = currentPosition.getyCord();
		
		int destinationX = destination.getxCord();
		int destinationY = destination.getyCord();
		
		int xDiff = Math.abs(currentX - destinationX);
		int yDiff = Math.abs(currentY - destinationY);
		
		// Moves 2.5
		return (xDiff==1 && yDiff==2) || (xDiff==2 && yDiff==1);
	}
}
