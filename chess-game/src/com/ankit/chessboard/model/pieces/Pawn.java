package com.ankit.chessboard.model.pieces;

import com.ankit.chessboard.constants.CoreConstants;
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
		int currentX = currentPosition.getRow();
		int currentY = currentPosition.getCol();
		
		int destinationX = destination.getRow();
		int destinationY = destination.getCol();
		
		// It will move only 1 step vertically forward.
		if(currentY==destinationY && currentX - destinationX == CoreConstants.Integer.ONE) {
			return true;
		}
		return false;
	}

}
