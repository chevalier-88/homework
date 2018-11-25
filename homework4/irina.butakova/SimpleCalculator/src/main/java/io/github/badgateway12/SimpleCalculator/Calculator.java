package io.github.badgateway12.SimpleCalculator;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

@Configuration
public class Calculator
{
    private final OperandStack operandStack = new OperandStack();
    private final Deque<Token> operatorStack = new ArrayDeque<>();

    public double calculate(Collection<Token> tokens) {
        operandStack.clear();;
        operatorStack.clear();
        for (Token token: tokens)
            if (token.isOperand())
                operandStack.push(new Operand(token.getSequence()));
            else if (token.isOpenParenthesis())
                operatorStack.push(token);
            else if (token.isCloseParenthesis()) {
                while (!operatorStack.peek().isOpenParenthesis()) {
                    doCalculate();
                }
                operatorStack.pop();
            }
            else if (token.isOperator()) {
                while (!operatorStack.isEmpty() && operatorStack.peek().isOperator() && hasPrecedence(token)) {
                    doCalculate();
                }
                operatorStack.push(token);
            }
        while (!operatorStack.isEmpty()) {
            doCalculate();
        }
        return operandStack.pop().getValue();
    }

    private boolean hasPrecedence(Token token) {
        int currentPrecedence = OperatorFactory.getOperator(token.getSequence()).getPrecedence();
        int previousPrecedence = OperatorFactory.getOperator(operatorStack.peek().getSequence()).getPrecedence();
        return  currentPrecedence <= previousPrecedence;
    }

    private void doCalculate() {
        Operator operator = OperatorFactory.getOperator(operatorStack.pop().getSequence());
        operator.execute(operandStack);
    }
}
