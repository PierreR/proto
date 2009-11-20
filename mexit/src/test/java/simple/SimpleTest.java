package simple;

import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Date: Nov 18, 2009
 */

public class SimpleTest {
    protected int fValue1;
    protected int fValue2;

    @Before
    public void setUp() {
        fValue1= 2;
        fValue2= 3;
    }

    @Test(expected = ArithmeticException.class) public void divideByZero() {
        int zero= 0;
        int result= 8/zero;
        result++; // avoid warning for not using result
    }


}

