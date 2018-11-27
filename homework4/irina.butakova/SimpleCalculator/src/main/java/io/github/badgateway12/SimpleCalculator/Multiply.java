package io.github.badgateway12.SimpleCalculator;

public class Multiply implements BinaryOperator {
    @Override
    public void execute(OperandStack stack) {
        Operand rho = stack.pop();
        Operand lho = stack.pop();
        stack.push(lho.multiply(rho));
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
