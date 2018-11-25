package io.github.badgateway12.SimpleCalculator;

import java.util.ArrayDeque;

public class OperandStack {
    private ArrayDeque<Operand> stack;

    public OperandStack() {
        stack = new ArrayDeque<>();
    }

    public Operand pop() {
        return stack.pop();
    }

    public void push(Operand operand) {
        stack.push(operand);
    }

    public Operand peek() {
        return stack.peek();
    }

    public void clear() {
        stack = new ArrayDeque<>();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
