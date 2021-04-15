package petproject.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {


//    @Test
//    public void calculateResult() {
//
//    }

    @Test
    public void parseInput() {
        TestResourceLoader resources = new TestResourceLoader();
        double[] actual = new double[resources.expected.length];
        int i=0;
        for (String item: resources.inputStrings) {
            Calculator.parseInput(item);
            actual[i++] = Calculator.calculateResult();
        }
        assertArrayEquals(resources.expected, actual, 1E-9);
    }

//    @Test
//    public void calculateMultDiv() {
//    }
}