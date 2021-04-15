package petproject.app;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceLoader {
    private static final ResourceBundle testRes = ResourceBundle.getBundle("TestInputs", new Locale("en", "US"));
    ArrayList<String> inputStrings;
    double[] expected;

    public TestResourceLoader() {
        int inputLength = testRes.keySet().size()/2;
        this.inputStrings = new ArrayList<>(inputLength);
        this.expected = new double[inputLength];
        for (int i=0; i < inputLength; i++) {
            this.inputStrings.add(testRes.getString("inputString." + i));
            this.expected[i] = Double.parseDouble(testRes.getString("expectedResult." + i));
        }
    }

}
