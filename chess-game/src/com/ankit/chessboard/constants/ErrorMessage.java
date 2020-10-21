package com.ankit.chessboard.constants;

public interface ErrorMessage {

	String NO_ANY_POSSIBLE_MOVES = "No any possible moves!";
	String EMPTY_INPUT = "ERROR! Input is empty. ";
	String INVALID_INPUT_MESSAGE = "ERROR! It must contain valid piece type and current position Eg. 'King D5'";
	String INVALID_PIECE_OR_CELL_MESSAGE = "ERROR! Piece Type must be one of these- King, Queen, Bishop, Horse, Rook, Pawn and cell no must be among A1..A8..H8.\n  Eg. 'King D5', 'Queen A6'";

}
