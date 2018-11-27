package io.github.badgateway12.SimpleCalculator;

import static java.lang.Double.parseDouble;

public class Operand {
    private double value;

    private Operand (double value) {
        this.value = value;
    }

    public Operand(String value) {
        try {
            this.value = parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Unknown character");
        }
    }

    public double getValue() {
        return value;
    }

    public Operand add(Operand other) {
        return new Operand(value + other.value);
    }

    public Operand subtract(Operand other) {
        return new Operand(value - other.value);
    }

    public Operand multiply(Operand other) {
        return new Operand(value * other.value);
    }

    public Operand divide(Operand other) {
        try {
            return new Operand(value / other.value);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
