package SCF_Session6_ADT;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {
    Polynomial polydefault = new Polynomial();
    Polynomial poly = new Polynomial(new int[][] { { 2, 0 }, { 3, 1 },
            { 1, 3 }, { 4, 2 } });

    @Test
    public void testDegree() {
        int result = poly.degree();
        assertEquals(3, result);
    }

    @Test
    public void testEvaluate() {
        double result = poly.evaluate(2);
        assertEquals(32, result, 0.001);
    }

    @Test
    public void testAdd1() {

        Polynomial poly1 = new Polynomial(new int[][] { { 2, 0 }, { 3, 1 },
                { 1, 3 }, { 4, 2 } });
        Polynomial poly2 = new Polynomial(new int[][] { { 4, 0 }, { 2, 1 },
                { 1, 3 } });
        int result[][] = polydefault.add(poly1, poly2);
        int expected[][] = { { 6, 0 }, { 5, 1 }, { 4, 2 }, { 2, 3 } };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAdd2() {

        Polynomial poly1 = new Polynomial(new int[][] { { 2, 1 }, { 2, 2 } });
        Polynomial poly2 = new Polynomial(new int[][] { { 2, 0 }, { 5, 1 },
                { 5, 2 } });
        int result[][] = polydefault.add(poly1, poly2);
        int expected[][] = { { 2, 0 }, { 7, 1 }, { 7, 2 } };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAdd3() {

        Polynomial poly1 = new Polynomial(new int[][] { { 1, 4 }, { 1, 5 } });
        Polynomial poly2 = new Polynomial(new int[][] { { 1, 0 }, { 1, 2 },
                { 1, 3 } });
        int result[][] = polydefault.add(poly1, poly2);
        int expected[][] = { { 1,0 }, { 1,2 }, { 1,3 },{ 1,4 },{ 1,5 } };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultiply1() {

        Polynomial poly3 = new Polynomial(new int[][] { { 4, 6 }, { 3, 1 } });
        Polynomial poly4 = new Polynomial(new int[][] { { 4, 1 }, { 3, 3 } });
        int result[][] = polydefault.multiplyPoly(poly3, poly4);
        int expected[][] = { { 12, 2 }, { 9, 4 }, { 16, 7 }, { 12, 9 } };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultiply2() {

        Polynomial poly5 = new Polynomial(new int[][] { { 1, 1 }, { 2, 2 } });
        Polynomial poly6 = new Polynomial(new int[][] { { 2, 0 }, { 3, 1 } });
        int result[][] = polydefault.multiplyPoly(poly5, poly6);
        int expected[][] = { { 2, 1 }, { 7, 2 }, { 6, 3 } };
        assertArrayEquals(expected, result);
    }

}
