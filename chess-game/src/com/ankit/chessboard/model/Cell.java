package com.ankit.chessboard.model;

/**
 * Abstract class parent to all the pieces
 *
 * @version V1.0
 * @author Ankit
 * */
public class Cell {

	// Variable to store x cordinate of the cell.
	private int xCord;
	
	// Variable to store y cordinate of the cell.
	private int yCord;
	
	public Cell(int x, int y) {
		this.xCord = x;
		this.yCord = y;
	}
	public int getxCord() {
		return xCord;
	}
	public void setxCord(int xCord) {
		this.xCord = xCord;
	}
	public int getyCord() {
		return yCord;
	}
	public void setyCord(int yCord) {
		this.yCord = yCord;
	}
	
	/**
	 * convert a stringifiedCell cell position to exact coordinates and wrap in Cell objet
	 * Eg. "D5" will be converted to [3,3]
	 * 
	 * @param stringifiedCell
	 * @return Cell
	 * */
	public static Cell convertToBox(String stringifiedCell) {
		int xPosition = Integer.parseInt(stringifiedCell.substring(1));
		int x = 8 - xPosition;
		char yPosition = stringifiedCell.charAt(0);
		int y = yPosition - 'A';
		return new Cell(x, y);
	}
	
	/**
	 * Convert a Cell object in stringified format
	 * Eg.  [3,3] will be converted to "D5"
	 * 
	 * @return String
	 * */
	public String stringifiedCell() {
		int convertedX = 8 - this.xCord;
		char convertedY = (char) ('A'+this.yCord);
		return new StringBuffer().append(convertedY).append(convertedX).toString();
	}
	
}
