package main.java;

import main.java.structures.*;

import static java.lang.Character.*;

public class Calculator {
    Stack <Double> stack = new Stack <Double>();
    List <Character> operators = new List<Character>() {{
        add('+'); add('-'); add('*'); add('/'); add('^');
    }};
    Converter converter = new Converter();

    public double evalPrefix(String prefix) {
        String doubleStr = "";
        int i = prefix.length() - 1;
        double op1, op2;

        while (i >= 0) {
            if (isDigit(prefix.charAt(i))) {
                while (prefix.charAt(i) != ' ') {
                    doubleStr += prefix.charAt(i);
                    i--;
                }

                stack.push(Double.parseDouble(converter.reverse(doubleStr)));
                doubleStr = "";

            } else if (operators.contains(prefix.charAt(i))) {
                if (stack.size() >= 2) {
                    op1 = stack.peek();
                    stack.pop();
                    op2 = stack.peek();
                    stack.pop();

                    if (prefix.charAt(i) == '-') stack.push(op1 - op2);
                    else if (prefix.charAt(i) == '+') stack.push(op1 + op2);
                    else if (prefix.charAt(i) == '*') stack.push(op1 * op2);
                    else if (prefix.charAt(i) == '/') stack.push(op1 / op2);
                    else if (prefix.charAt(i) == '^') stack.push(pow(op1, op2));
                }

                i--;
            }

            while(i >= 0 && prefix.charAt(i) == ' ') i--;
        }

        return stack.peek();
    }

    double pow (double base, double power) {
        if (power == 0.0) return 1;

        double result = 1;
        for (int i = 0; i < Math.abs((int) power); i++) {
            result *= base;
        }

        if (power < 0) result = 1 / result;

        return result;
    }
}
