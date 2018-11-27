package io.github.badgateway12.SimpleCalculator;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class Validator {
    private final Pattern expression = Pattern.compile("[-]?\\d*\\.?\\d+([-+*/](?<!\\d)[-]?\\d*\\.?\\d+)*");
    private final Pattern parentheses = Pattern.compile("[(]([^()]*)[)]");

    public void validate(String input) {
        input = input.replaceAll("\\s+","");

        while (input.contains(")") || input.contains("(")) {
            Matcher matcher = parentheses.matcher(input);
            if (matcher.find()) {
                if (!expression.matcher(matcher.group(1)).matches()) {
                    throw new IllegalArgumentException("Parantheses mismatch");
                }
                input = input.substring(0, matcher.start()) + " 1 " + input.substring(matcher.end());
                input = input.replaceAll("\\s+","");

            } else {
                throw new IllegalArgumentException("Parantheses mismatch");
            }
        }
        if (!expression.matcher(input).matches())
            throw new IllegalArgumentException("Extra token");
    }
}
