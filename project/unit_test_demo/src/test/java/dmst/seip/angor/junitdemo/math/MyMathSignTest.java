package dmst.seip.angor.junitdemo.math;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyMathSignTest {

    MyMath mm = new MyMath();

    @Parameter(0)
    public int inputNumber;

    @Parameter(1)
    public String expectedResult;

    // The valid inputs (Positive and Negative)
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3, "positive" },
                { -3, "negative" }
        });
    }

    @Test
    public void testCheckSign() {
        Assert.assertEquals(expectedResult, mm.checkSign(inputNumber));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckSignException() {
        mm.checkSign(0); //this method will run 2 times
    }
}