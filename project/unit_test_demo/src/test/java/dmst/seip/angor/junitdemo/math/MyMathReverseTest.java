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
public class MyMathReverseTest {
    MyMath mm = new MyMath();

    @Parameter(0)
    public int inputNumber;

    @Parameter(1)
    public int expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, -5 },   // Case 1: Positive -> Negative
                { -3, 3 },   // Case 2: Negative -> Positive
                { 0, 0 }     // Case 3: Zero -> Zero
        });
    }

    // 4. The Single Test Method that runs 3 times
    @Test
    public void testReverseNumber() {
        Assert.assertEquals(expectedResult, mm.reverseNumber(inputNumber));
    }
}