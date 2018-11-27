package io.github.badgateway12.SimpleCalculator;

public class Add implements BinaryOperator {
    @Override
    public void execute(OperandStack stack) {
        Operand rho = stack.pop();
        Operand lho = stack.pop();
        stack.push(lho.add(rho));
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
