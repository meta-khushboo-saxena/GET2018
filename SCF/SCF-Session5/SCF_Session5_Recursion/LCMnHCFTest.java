package SCF_Session5_Recursion;
import static org.junit.Assert.*;
import org.junit.Test;

public class LCMnHCFTest {

    LCMnHCF lcmHcf = new LCMnHCF();
    @Test
    public void TestHCF1()
    {
       int result = lcmHcf.HCF(5,2); 
       assertEquals(1, result);
    }
    
    @Test
    public void TestHCF2()
    {
       int result = lcmHcf.HCF(4,12); 
       assertNotEquals(3, result);
    }
    
    @Test
    public void TestLCM1()
    {
       int result = lcmHcf.LCM(3,9); 
       assertEquals(9, result);
    }
    
    @Test
    public void TestLCM2()
    {
       int result = lcmHcf.LCM(4,12); 
       assertNotEquals(3, result);
    }
}
