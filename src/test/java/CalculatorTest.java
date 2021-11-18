package test.java;

import main.java.*;
import main.java.structures.*;
import org.junit.*;
import org.junit.Assert.*;

public class CalculatorTest {
    Converter converter = new Converter();
    Calculator calculator = new Calculator();

    Map <String, Double> exp = new Map <String, Double>() {{
        put("1 - 1 + 1 - 1 + 1 - 1 + 1 - 1 + 1 - 1", 0.0d);
        put("1.5 - 2.33 * 6.33 ^ 2 / 16.16", -4.277d);
        put("-1 ^ 4 + -2^4 * 3 * (15.4 - 13.3 * 12 / 10)", -21.603d);
        put("(2 + 4) * 6 + 2 ^ 4 - (14 - (16 + 18) * 2 - (13 - (7 - 5 * 4)))", 80.0d);
    }};

    double error = 0.1;

    @Test
    public void testEvalPrefix() {
        double result;

        for (int i = 0; i < exp.size(); i++) {
            result = calculator.evalPrefix(converter.infixToPrefix(exp.getKeyByIndex(i)));
            Assert.assertTrue(Math.abs(result - exp.getValueByIndex(i)) < error);
        }
    }

}
