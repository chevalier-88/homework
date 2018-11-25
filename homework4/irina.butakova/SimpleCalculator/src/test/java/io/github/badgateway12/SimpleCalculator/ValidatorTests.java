package io.github.badgateway12.SimpleCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ValidatorTests {
    private Validator validator = new Validator();

    @Test(expected = IllegalArgumentException.class)
    public void testValidate__InvalidInput_ThrowsException() {
        validator.validate("--3");
        validator.validate("0.3.");
        validator.validate("(3");
        validator.validate("(5+2^)");
        validator.validate("1-+3");
        validator.validate("1---3");
        validator.validate("((3+1)");
        validator.validate("-.3");
        validator.validate("3+.7");
    }
}
