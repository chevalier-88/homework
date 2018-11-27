package com.gmail.vladimir.chevalier.calculator;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CalcPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        String msg = String.format("example expression: \"calc 2+2\" and press enter \n input your expression: >");
        return new AttributedString(msg);
    }
}
