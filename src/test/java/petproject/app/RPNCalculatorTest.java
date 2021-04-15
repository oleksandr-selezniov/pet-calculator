package petproject.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPNCalculatorTest {

    @Test
    public void calc() throws Exception {
        TestResourceLoader resources = new TestResourceLoader();
        double[] actual = new double[resources.expected.length];
        int i=0;
        for (String item: resources.inputStrings) {
            actual[i++] = RPNCalculator.calc(item);
        }
        assertArrayEquals(resources.expected, actual, 1E-9);
    }
}