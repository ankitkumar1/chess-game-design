package com.ankit.chessboard.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.ankit.chessboard.service.ChessPlayService;

/**
 * Test class
 * Tests cases including invalid inputs and corner movements for any piece.
 * 
 * @author Ankit
 * */
public class ChessPlayServiceTest {

	private ChessPlayService service = new ChessPlayService();
	
	@Test
	public void testEmptyInput() {
		String possibleMoves = service.getPossibleMoves("");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(true, possibleMoves.startsWith("ERROR"));
	}
	
	@Test
	public void testInvalidCellNo() {
		String possibleMoves = service.getPossibleMoves("King A9");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(true, possibleMoves.startsWith("ERROR"));
	}
	
	@Test
	public void testInvalidPieceType() {
		String possibleMoves = service.getPossibleMoves("Elephant A6");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(true, possibleMoves.startsWith("ERROR"));
	}
	
	@Test
	public void testDistortedInput() {
		String possibleMoves = service.getPossibleMoves("abcdefgh");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(true, possibleMoves.startsWith("ERROR"));
	}
	
	@Test
	public void kingMoveFromD5() {
		String possibleMoves = service.getPossibleMoves("King D5");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("C6", "D6", "E6", "C5", "E5", "C4", "D4", "E4"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void kingMoveFromA3() {
		String possibleMoves = service.getPossibleMoves("King A3");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("A4", "B4", "B3", "A2", "B2"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void kingMoveFromH8() {
		String possibleMoves = service.getPossibleMoves("King H8");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("G8", "G7", "H7"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void queenMoveFromH8() {
		String possibleMoves = service.getPossibleMoves("Queen H8");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("A8", "B8", "C8", "D8", "E8", "F8", "G8", "G7", "H7", "F6",
				"H6", "E5", "H5", "D4", "H4", "C3", "H3", "B2", "H2", "A1", "H1"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void queenMoveFromD5() {
		String possibleMoves = service.getPossibleMoves("Queen D5");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("A8", "D8", "G8", "B7", "D7", "F7", "C6", "D6", "E6", "A5",
				"B5", "C5", "E5", "F5", "G5", "H5", "C4", "D4", "E4", "B3", "D3", "F3", "A2", "D2", 
				"G2", "D1", "H1"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void queenMoveFromE1() {
		String possibleMoves = service.getPossibleMoves("Queen E1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("E8", "E7", "E6", "A5", "E5", "B4", "E4", "H4", "C3", "E3",
				"G3","D2", "E2", "F2", "A1", "B1", "C1", "D1", "F1", "G1", "H1"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void horseMoveFromH8() {
		String possibleMoves = service.getPossibleMoves("Horse H8");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("F7", "G6"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void horseMoveFromD5() {
		String possibleMoves = service.getPossibleMoves("Horse D5");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("C7", "E7", "B6", "F6", "B4", "F4", "C3", "E3"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void horseMoveFromE1() {
		String possibleMoves = service.getPossibleMoves("Horse E1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("D3", "F3", "G2", "C2"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void bishopMoveFromE1() {
		String possibleMoves = service.getPossibleMoves("Bishop E1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("D2", "F2", "C3", "G3","B4","H4","A5"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void bishopMoveFromA1() {
		String possibleMoves = service.getPossibleMoves("Bishop A1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("B2", "C3", "D4", "E5","F6","G7","H8"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void bishopMoveFromE4() {
		String possibleMoves = service.getPossibleMoves("Bishop E4");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("H1", "G2", "F3", "H7", "G6", "F5", "D3", "C2",
				"B1", "D5", "C6", "B7", "A8"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void rookpMoveFromA1() {
		String possibleMoves = service.getPossibleMoves("Rook A1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("A2","A3","A4","A5","A6","A7","A8","B1",
				"C1","D1","E1","F1","G1","H1"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void rookMoveFromD7() {
		String possibleMoves = service.getPossibleMoves("Rook D7");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("D8", "A7", "B7", "C7", "E7", "F7", 
				"G7", "H7", "D6", "D5", "D4", "D3", "D2", "D1"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void pawnMoveFromA1() {
		String possibleMoves = service.getPossibleMoves("Pawn A1");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("A2"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void pawnMoveFromD8() {
		String possibleMoves = service.getPossibleMoves("Pawn D8");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(true, possibleMoves.startsWith("No"));
	}
	
	@Test
	public void pawnMoveFromE5() {
		String possibleMoves = service.getPossibleMoves("Pawn E5");
		Assert.assertNotNull(possibleMoves);
		Assert.assertEquals(false, possibleMoves.startsWith("ERROR"));
		Set<String> expected = new HashSet<>(Arrays.asList("E6"));
		Set<String> actual = Stream.of(possibleMoves.split(", ")).collect(Collectors.toSet());
		Assert.assertEquals(expected, actual);
	}
}
