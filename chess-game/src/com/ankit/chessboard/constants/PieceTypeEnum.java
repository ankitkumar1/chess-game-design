package com.ankit.chessboard.constants;

/**
 * Enum class to store piece information and their string representation value
 * 
 * @version 1.1
 * @author Ankit
 * */
public enum PieceTypeEnum {

	KING("King"),
	QUEEN("Queen"),
	BISHOP("Bishop"),
	HORSE("Horse"),
	ROOK("Rook"),
	PAWN("Pawn");

	private final String value;

	private PieceTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
