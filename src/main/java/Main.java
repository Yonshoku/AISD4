package main.java;

import main.java.structures.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exitLine = "exit";

        Converter converter = new Converter();
        Calculator calculator = new Calculator();

        // Get expressions until "exit" encountered
        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();
        String prefix; double result;

        while (!input.equals(exitLine)) {
            prefix = converter.infixToPrefix(input); // Convert expression to prefix
            System.out.println("Prefix notation: " + prefix);

            result = calculator.evalPrefix(prefix);
            System.out.println("Result: " + Double.valueOf(new DecimalFormat("#.###").format(result)));

            System.out.print("Enter an expression: ");
            input = scanner.nextLine();
        }

    }
}
