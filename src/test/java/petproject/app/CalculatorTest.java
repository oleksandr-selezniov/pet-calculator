package petproject.app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculatorTest {


//    @Test
//    public void calculateResult() {
//
//    }

    @Test
    public void parseInput() {
        ArrayList<String> inputStrings = new ArrayList<>(5);
        inputStrings.add(0, "2 + 3");
        inputStrings.add(1, "11 / 12 * 12 / 11");
        inputStrings.add(2, "4 - 6");
        inputStrings.add(3, "56.7 * 3.12");
        inputStrings.add(4, "4 * 4");
        double[] expected = {5.0, 1.0, -2.0, 176.904, 16.0};
        double[] actual = {0,0,0,0,0};
        int i=0;
        for (String item: inputStrings) {
            Calculator.parseInput(item);
            actual[i++] = Calculator.calculateResult();
        }
        assertArrayEquals(expected, actual, 1E-9);
    }

//    @Test
//    public void calculateMultDiv() {
//    }
}