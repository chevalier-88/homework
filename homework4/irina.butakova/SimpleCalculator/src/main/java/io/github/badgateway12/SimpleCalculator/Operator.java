package io.github.badgateway12.SimpleCalculator;

public interface Operator {
    void execute(OperandStack stack);
    int getPrecedence();
}
