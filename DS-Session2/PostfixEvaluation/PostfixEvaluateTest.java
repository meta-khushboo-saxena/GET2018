package PostfixEvaluation;
import static org.junit.Assert.*;
import org.junit.Test;

public class PostfixEvaluateTest {
	PostfixEvaluate postfix = new PostfixEvaluate();
    // Positive Test
    @Test
    public void testForPostfix() {
        
        assertEquals(34, postfix.evaluate("22 3 1 * + 9 +"));
    }

    // Positive Test
    @Test
    public void testForPostfix2() {
        assertEquals(14, postfix.evaluate("2 3 1 * + 9 +"));
    }

    // Positive Test
    @Test
    public void testForPostfix3() {
        assertEquals(13, postfix.evaluate("1 3 1 * + 9 +"));
    }

    // Positive Test
    @Test
    public void testForPostfix4() {
        assertEquals(331, postfix.evaluate("22 3 100 * + 9 +"));
    }
}