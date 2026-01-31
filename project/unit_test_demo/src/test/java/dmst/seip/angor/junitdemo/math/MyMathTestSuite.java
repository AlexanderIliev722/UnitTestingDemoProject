package dmst.seip.angor.junitdemo.math;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		MyMathReverseTest.class,
		MyMathSignTest.class,
		MyAdvancedMathTest.class,
		MyAdvancedMathPowerOfTwoParameterizedTest.class,
		MyAdvancedMathAddTest.class
})
public class MyMathTestSuite {

}
