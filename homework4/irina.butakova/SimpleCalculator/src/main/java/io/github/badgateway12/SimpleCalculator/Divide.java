package io.github.badgateway12.SimpleCalculator;

public class Divide implements BinaryOperator {
    @Override
    public void execute(OperandStack stack) {
        Operand rho = stack.pop();
        Operand lho = stack.pop();
        stack.push(lho.divide(rho));
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
