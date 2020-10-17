package com.ankit.chessboard;

import com.ankit.chessboard.constants.PieceTypeEnum;
import com.ankit.chessboard.model.Cell;
import com.ankit.chessboard.model.pieces.Bishop;
import com.ankit.chessboard.model.pieces.Horse;
import com.ankit.chessboard.model.pieces.King;
import com.ankit.chessboard.model.pieces.Pawn;
import com.ankit.chessboard.model.pieces.Piece;
import com.ankit.chessboard.model.pieces.Queen;
import com.ankit.chessboard.model.pieces.Rook;

/**
 * Factory class to build and instance of Piece based on input pieceType.<br>
 * Eg. if Input is "King" it will instantiate King class<br>
 * 	   If Input is "Queen" it will instantiate Queen class and so on..
 * 
 * @version 1.1
 * @author Ankit
 * */
public class PieceFactory {

	public Piece buildPiece(String pieceTypeValue, Cell currentCell) {
		Piece piece = null;
		// Fetching fixed type of piece from PieceTypeEnum
		PieceTypeEnum pieceType = PieceTypeEnum.valueOf(pieceTypeValue.toUpperCase());
		
		switch (pieceType) {
		case KING:
			piece = new King(currentCell);
			break;
		case QUEEN:
			piece = new Queen(currentCell);
			break;
		case BISHOP:
			piece = new Bishop(currentCell);
			break;

		case HORSE:
			piece = new Horse(currentCell);
			break;

		case ROOK:
			piece = new Rook(currentCell);
			break;

		case PAWN:
			piece = new Pawn(currentCell);
			break;

		default:
			break;
		}
		return piece;
	}
}
