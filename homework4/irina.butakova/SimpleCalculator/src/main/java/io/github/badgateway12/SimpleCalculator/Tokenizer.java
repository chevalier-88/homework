package io.github.badgateway12.SimpleCalculator;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class Tokenizer {
    private final Pattern lexems = Pattern.compile("\\(|\\)|(?<!\\d)[-]?\\d*\\.?\\d+|[-+/*]");

    public Collection<Token> tokenize(String input) {
        ArrayList<Token> tokens = new ArrayList<>();

        Matcher matcher = lexems.matcher(input);

        while (matcher.find()) tokens.add(new Token(matcher.group()));

        return tokens;
    }
}
