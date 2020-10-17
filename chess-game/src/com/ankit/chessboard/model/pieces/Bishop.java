package com.ankit.chessboard.model.pieces;

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
		int currentX = currentPosition.getxCord();
		int currentY = currentPosition.getyCord();
		
		int destinationX = destination.getxCord();
		int destinationY = destination.getyCord();
		
		int xDiff = Math.abs(currentX - destinationX);
		int yDiff = Math.abs(currentY - destinationY);
		
		// Moves only diagonally
		return xDiff == yDiff && xDiff>0;
	}

}
