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
public class MyAdvancedMathAddTest {

    MyAdvancedMath mam = new MyAdvancedMath();

    // Inputs
    @Parameter(0)
    public int inputX;

    @Parameter(1)
    public int inputY;

    // Output
    @Parameter(2)
    public int expectedSum;

    // The Data: { x, y, ExpectedResult }
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, 2, 7 },      // Normal Case
                { 0, 0, 0 },      // Zero Case
                { 10, 20, 30 }    // Extra check
        });
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(expectedSum, mam.add(inputX, inputY));
    }
}