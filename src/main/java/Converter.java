package main.java;

import main.java.structures.*;

import static java.lang.Character.*;

public class Converter {
    Stack <Character> opStack = new Stack <Character>(); // Stack for operators and braces
    Map <Character, Integer> opPriority = new Map <Character, Integer>() {{ // Map of operators priority
        put(')', 0);
        put('(', 0);
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('^', 3);
    }};


    public String infixToPrefix(String exp) {
        exp = exp.replaceAll("\\s",""); // Remove all whitespaces and non-visible characters
        exp = reverse(exp);

        exp += ")";
        opStack.push('(');

        String prefix = "";

        for (int i = 0; i < exp.length(); i++) {

            if (exp.charAt(i) == '(') {
                opStack.push('(');

            } else if (exp.charAt(i) == ')') {

                while (opStack.peek() != '(') {
                    prefix += opStack.peek() + " ";
                    opStack.pop();
                }
                opStack.pop();

            } else if (opPriority.containsKey(exp.charAt(i))) {
                // Unary minus
                if (exp.charAt(i) == '-' && i + 1 < exp.length() && opPriority.containsKey(exp.charAt(i + 1))
                        && exp.charAt(i + 1) != ')' && exp.charAt(i + 1) != '(') {
                    prefix += exp.charAt(i) + " ";
                    continue;
                }

                while (opPriority.get(opStack.peek()) >= opPriority.get(exp.charAt(i))) {
                    prefix += opStack.peek() + " ";
                    opStack.pop();
                }

                opStack.push(exp.charAt(i));

            } else if (isDigit(exp.charAt(i)) || exp.charAt(i) == '.'){
                prefix += exp.charAt(i);

                // Dont make a spaces inside of one operand
                try {
                    if (isDigit(exp.charAt(i + 1)) || exp.charAt(i + 1) == '.') continue;
                    if (exp.charAt(i + 1) == '-' && opPriority.containsKey(exp.charAt(i + 2))
                     && exp.charAt(i + 2) != ')' && exp.charAt(i + 2) != '(') continue;
                    prefix += " ";
                } catch (Exception e) {}
            }
        }

        for (int i = 0; i < opStack.size(); i++) {
            prefix += opStack.peek() + " ";
            opStack.pop();
        }

        return reverse(prefix);
    }

    String reverse(String str) {
        char temp;
        char[] charArray = str.toCharArray();

        // Swap chars from the left to the right and vice versa
        for (int i = 0; i < charArray.length / 2; i++) {
            temp = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = charArray[i];
            charArray[i] = temp;
        }

        // Interchange left and right parentheses
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ')') {
                charArray[i] = '(';
                continue;
            }
            if (charArray[i] == '(') charArray[i] = ')';
        };

        // Convert char array back to string
        return String.valueOf(charArray);
    }
}
