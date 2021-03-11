package petproject.app;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPNCalculator {

    private static int priority(String op) {
        return op.equals("+") || op.equals("-") ? 1 : op.equals("*") || op.equals("/") ? 2 : -1;
    }

    private static void process_op(LinkedList<Double> num, String op) {
        Double r = num.getFirst();  num.removeFirst();
        Double l = num.getFirst();  num.removeFirst();
        switch (op) {
            case "+" -> num.addFirst(l + r);
            case "-" -> num.addFirst(l - r);
            case "*" -> num.addFirst(l * r);
            case "/" -> num.addFirst(l / r);
        }
    }
    public static Double calc (String input) throws Exception {
        String[] s = input.split(" ");
        LinkedList<Double> numbers = new LinkedList<>();
        LinkedList<String> operations = new LinkedList<>();
        String opRegex = "[+\\-*/]";
        String numRegex = "^\\d+(?:\\.\\d+)?$";
        Pattern operation = Pattern.compile(opRegex, Pattern.MULTILINE);
        Pattern number = Pattern.compile(numRegex, Pattern.MULTILINE);
        for (int i=0; i<s.length; i++) {
            s[i] = s[i].strip();
            Matcher matchOp = operation.matcher(s[i]);
            Matcher matchNum = number.matcher(s[i]);
            if (!s[i].equals("")) {
                if (s[i].equals("("))
                    operations.addFirst ("(");
                else if (s[i].equals(")")) {
                    while (!operations.getFirst().equals("(")) {
                        process_op(numbers, operations.getFirst());
                        operations.removeFirst();
                    }
                    operations.removeFirst();
                }
                else if (matchOp.matches()) {
                    String currOp = s[i];
                    while (!operations.isEmpty() && priority(operations.getFirst()) >= priority(s[i])) {
                        process_op (numbers, operations.getFirst());
                        operations.removeFirst();
                    }
                    operations.addFirst (currOp);
                }
                else if (matchNum.matches()) {
                        numbers.addFirst(Double.parseDouble(s[i]));
                }
                else throw new Exception();
            }
        }
        while (!operations.isEmpty()) {
            process_op (numbers, operations.getFirst());
            operations.removeFirst();
        }
        return numbers.getFirst();
    }
}
