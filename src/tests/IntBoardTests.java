package tests;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.*;

import clueGame.Board;
import experiment.BoardCell;
import experiment.IntBoard;

public class IntBoardTests {
	private IntBoard board;
	
	@Before 
	public void createIntBoard() {
		board = new IntBoard(4,4);
	}
	
	//test adjacencies------------------------------------------------------------------------------
	@Test
	public void testAdjacency0() { //top left corner
		BoardCell cell = board.getCell(0,0);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertEquals(2, testList.size());
	}
	
	@Test
	public void testAdjacency15() { //bottom right corner
		BoardCell cell = board.getCell(3,3);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(2, testList.size());
	}
	
	@Test
	public void testAdjacency7() { //test 1,3
		BoardCell cell = board.getCell(1,3);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(0, 3)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(3, testList.size());
	}
	
	@Test
	public void testAdjacency4() { //test 1,0
		BoardCell cell = board.getCell(1,0);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(0, 0)));
		assertTrue(testList.contains(board.getCell(1, 1)));
		assertTrue(testList.contains(board.getCell(2, 0)));
		assertEquals(3, testList.size());
	}
	
	@Test
	public void testAdjacency5() { //test 1,1
		BoardCell cell = board.getCell(1,1);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacency10() { //test 2,2
		BoardCell cell = board.getCell(2,2);
		Set<BoardCell> testList = board.getAdjacencies(cell);
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(4, testList.size());
	}
	
	//test targets-------------------------------------------------------------------------------
	@Test
	public void testTargets6_2() { //test cell 1,2 with 2 moves
		BoardCell cell = board.getCell(1, 2);
		board.calcTargets(cell, 2);
		Set targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(3, 2)));
		assertTrue(targets.contains(board.getCell(2, 3)));
		assertTrue(targets.contains(board.getCell(0, 3)));
	}

	
	@Test
	public void testTargets0_3() { // test cell 0,0 with 3 moves
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 3);
		Set targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(1, 0)));
	}
	
	@Test
	public void testTargets0_1() { // test cell 0,0 with 1 moves
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 1);
		Set targets = board.getTargets();
		assertEquals(2, targets.size());
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(0, 1)));
	}
	
	@Test
	public void testTargets2_5() { // test cell 0,2 with 5 moves
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 5);
		Set targets = board.getTargets();
		assertEquals(8, targets.size()); 
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(1, 0)));
		assertTrue(targets.contains(board.getCell(0, 1)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(3, 2)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(2, 3)));
	}
	
	@Test
	public void testTargets5_2() { // test cell 1,1 with 2 moves
		BoardCell cell = board.getCell(1, 1);
		board.calcTargets(cell, 2);
		Set targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(0, 0)));
		assertTrue(targets.contains(board.getCell(2, 0)));
		assertTrue(targets.contains(board.getCell(3, 1)));
		assertTrue(targets.contains(board.getCell(0, 2)));
		assertTrue(targets.contains(board.getCell(2, 2)));
		assertTrue(targets.contains(board.getCell(1, 3)));
	}
	
	@Test
	public void testTargets15_3() { // test cell 3,3 with 3 moves
		BoardCell cell = board.getCell(3, 3);
		board.calcTargets(cell, 3);
		Set targets = board.getTargets();
		assertEquals(6, targets.size());
		assertTrue(targets.contains(board.getCell(3, 0)));
		assertTrue(targets.contains(board.getCell(2, 1)));
		assertTrue(targets.contains(board.getCell(1, 2)));
		assertTrue(targets.contains(board.getCell(3, 2)));
		assertTrue(targets.contains(board.getCell(0, 3)));
		assertTrue(targets.contains(board.getCell(2, 3)));
	}

}
