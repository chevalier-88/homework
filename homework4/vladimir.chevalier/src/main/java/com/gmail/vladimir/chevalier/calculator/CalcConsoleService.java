package com.gmail.vladimir.chevalier.calculator;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalcConsoleService {
    private final static String ANSI_YELLOW = "\u001B[33m";
    private final static String ANSI_RESET = "\u001B[0m";

    private final PrintStream out = System.out;

    public void write(String exp) {
        System.out.println(" write method expression- " + exp);
        this.out.print("> result- ");
        this.out.print(ANSI_YELLOW);
        this.out.print(exp + " = " + this.getResult(exp));
        this.out.print(ANSI_RESET);
        this.out.println();
    }

    private Double getResult(String expression) {
        Double result = null;

        List<Double> listOperands = new ArrayList<>();

        Pattern pOperands = Pattern.compile("[0-9][0.0-9.9]*");
        Pattern pOperators = Pattern.compile("[-|+|/|*]");

        Matcher mOperands = pOperands.matcher(expression);
        Matcher mOperators = pOperators.matcher(expression);

        while (mOperands.find()) {
            listOperands.add(Double.valueOf(mOperands.group().trim()));
        }

        int index = 0;
        while ((mOperators.find()) && (index < listOperands.size() - 1)) {

            switch (mOperators.group()) {
                case "+":
                    result = (result == null) ?
                            (listOperands.get(index) + listOperands.get(index + 1))
                            : (result + listOperands.get(index + 1));
                    break;
                case "-":
                    result = (result == null) ?
                            (listOperands.get(index) - listOperands.get(index + 1))
                            : (result - listOperands.get(index + 1));
                    break;
                case "/":
                    result = (result == null) ?
                            (listOperands.get(index) / listOperands.get(index + 1))
                            : (result / listOperands.get(index + 1));
                    break;
                case "*":
                    result = (result == null) ?
                            (listOperands.get(index) * listOperands.get(index + 1))
                            : (result * listOperands.get(index + 1));
                    break;
            }
            index++;
        }
        return result;
    }
}
