package SCF_Session5_Recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class N_QueenTest {
	N_Queen nqueen = new N_Queen();

	@Test
	public void test1() {
		boolean result = nqueen.funcOperation(new int[][] { { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, }, 0, 4);
		assertEquals(true, result);
	}

	@Test
	public void test2() {
		boolean result = nqueen
				.funcOperation(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 } }, 0, 8);
		assertEquals(true, result);
	}

}
