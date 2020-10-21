package com.ankit.chessboard.model;

import com.ankit.chessboard.constants.CoreConstants;

/**
 * Abstract class parent to all the pieces
 *
 * @version V1.1
 * @author Ankit
 * */
public class Cell {

	// Variable to store x cordinate of the cell.
	private int row;
	
	// Variable to store y cordinate of the cell.
	private int col;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}


	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}


	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}


	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}


	/**
	 * convert a stringifiedCell cell position to exact coordinates and wrap in Cell objet
	 * Eg. "D5" will be converted to [3,3]
	 * 
	 * @param stringifiedCell
	 * @return Cell
	 * */
	public static Cell convertToCell(String stringifiedCell) {
		int rowNumber = CoreConstants.Integer.EIGHT - Integer.parseInt(stringifiedCell.substring(1));
		int colNumber = stringifiedCell.charAt(CoreConstants.Integer.ZERO) - CoreConstants.Alphabet.A_CAPS;
		return new Cell(rowNumber, colNumber);
	}
	
	/**
	 * Convert a Cell object in stringified format
	 * Eg.  [3,3] will be converted to "D5"
	 * 
	 * @return String
	 * */
	public String stringifiedCell() {
		int convertedX = CoreConstants.Integer.EIGHT - this.row;
		char convertedY = (char) (CoreConstants.Alphabet.A_CAPS + this.col);
		return new StringBuffer().append(convertedY).append(convertedX).toString();
	}
	
}
