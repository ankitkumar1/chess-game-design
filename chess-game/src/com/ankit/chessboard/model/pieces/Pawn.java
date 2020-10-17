package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.model.Cell;

/**
 * Its a subclass of Piece
 * Pawn- Can move only 1 step at a time, in the forward direction, vertically.
 * @Note Since, boad is empty. it can move only in forward direction, vertically
 * 
 * @version 1.0
 * @author Ankit
 * */
public class Pawn extends Piece{

	public Pawn(Cell currentPosition) {
		super(currentPosition);
	}

	@Override
	public boolean canMove(Cell destination) {
		int currentX = currentPosition.getxCord();
		int currentY = currentPosition.getyCord();
		
		int destinationX = destination.getxCord();
		int destinationY = destination.getyCord();
		
		// It will move only 1 step vertically forward.
		if(currentY==destinationY && destinationX-currentX == 1) {
			return true;
		}
		return false;
	}

}
