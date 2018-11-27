package io.github.badgateway12.SimpleCalculator;

public class OperatorFactory {
    public static Operator getOperator(String sequence) {
        switch (sequence) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
        }
        return null;
    }
}
