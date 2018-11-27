package io.github.badgateway12.SimpleCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class CalculatorTests {

    private Calculator calculator = new Calculator();
    private double delta = 0.0001;

    @Parameterized.Parameter(value = 0)
    public Collection<Token> input;

    @Parameterized.Parameter(value = 1)
    public double expected;


    @Parameterized.Parameters(name = "{index}: calculate({0}) = {1}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {Arrays.asList(new Token("3"), new Token("+"), new Token("2")), 5.0 },
                {Arrays.asList(new Token("3"), new Token("-"), new Token("1.5")), 1.5 },
                {Arrays.asList(
                        new Token("-3"),
                        new Token("-"),
                        new Token("2"),
                        new Token("*"),
                        new Token("2")), -7.0 },
                {Arrays.asList(
                        new Token("("),
                        new Token("-3"),
                        new Token("-"),
                        new Token("-1"),
                        new Token(")"),
                        new Token("/"),
                        new Token("4")), -0.5 },
                {Arrays.asList(
                        new Token("("),
                        new Token("-0.3"),
                        new Token("+"),
                        new Token("1.3"),
                        new Token(")"),
                        new Token("/"),
                        new Token("4")), 0.25 },
                {Arrays.asList(
                        new Token("("),
                        new Token("-0.3"),
                        new Token("+"),
                        new Token("-0.7"),
                        new Token(")"),
                        new Token("*"),
                        new Token("5")), -5.0 }
        });
    }

    @Test
    public void testTokenize() {
        assertEquals(expected,  calculator.calculate(input), delta);
    }
}
