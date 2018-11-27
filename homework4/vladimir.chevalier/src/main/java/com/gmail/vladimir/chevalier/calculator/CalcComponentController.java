package com.gmail.vladimir.chevalier.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalcComponentController {
    @Autowired
    private CalcConsoleService console;

    @ShellMethod(value = "do calculation...", key = "calc")
    public void calculate(String exp) {
        System.out.println("expression- " + exp);
        console.write(exp);
    }
}
