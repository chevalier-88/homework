package io.github.badgateway12.SimpleCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TokenizerTests {

    private Tokenizer tokenizer = new Tokenizer();

    @Parameterized.Parameter(value = 0)
    public String input;

    @Parameterized.Parameter(value = 1)
    public Collection<Token> expected;


    @Parameterized.Parameters(name = "{index}: validate({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"-2", Arrays.asList(new Token("-2"))},

                {"3+2", Arrays.asList(
                        new Token("3"),
                        new Token("+"),
                        new Token("2"))},

                {"3--2", Arrays.asList(
                        new Token("3"),
                        new Token("-"),
                        new Token("-2"))},

                {"-1-.2", Arrays.asList(
                        new Token("-1"),
                        new Token("-"),
                        new Token(".2"))},

                {"-.2", Arrays.asList(new Token("-.2"))},

                {"(0.5*3)+(-2)", Arrays.asList(
                        new Token("("),
                        new Token("0.5"),
                        new Token("*"),
                        new Token("3"),
                        new Token(")"),
                        new Token("+"),
                        new Token("("),
                        new Token("-2"),
                        new Token(")"))},
                {"(-0.3+-0.7)*2", Arrays.asList(
                        new Token("("),
                        new Token("-0.3"),
                        new Token("+"),
                        new Token("-0.7"),
                        new Token(")"),
                        new Token("*"),
                        new Token("2"))},
                {"(-0.3--0.7)*5", Arrays.asList(
                        new Token("("),
                        new Token("-0.3"),
                        new Token("-"),
                        new Token("-0.7"),
                        new Token(")"),
                        new Token("*"),
                        new Token("5"))} });
    }

    @Test
    public void testTokenize() {
        assertEquals(expected,  tokenizer.tokenize(input));
    }
}
