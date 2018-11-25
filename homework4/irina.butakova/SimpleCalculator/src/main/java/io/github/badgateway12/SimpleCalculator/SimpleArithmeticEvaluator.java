package io.github.badgateway12.SimpleCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Size;
import java.util.Collection;


@ShellComponent
@SpringBootApplication
public class SimpleArithmeticEvaluator {

	private Validator validator;
	private Tokenizer tokenizer;
	private Calculator evaluator;

	@Autowired
	public SimpleArithmeticEvaluator(Validator validator, Tokenizer tokenizer, Calculator evaluator) {
		this.validator = validator;
		this.tokenizer = tokenizer;
		this.evaluator = evaluator;
	}

	@ShellMethod("Evaluates given expression.")
	public String evaluate(@Size(min = 1, max = 30)String input) {
		try {
			validator.validate(input);
			return String.valueOf(evaluator.calculate(tokenizer.tokenize(input)));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static void main(String[] args) {
		String[] disabledCommands = {"--spring.shell.command.exit.enabled=true"};
		String[] fullArgs = StringUtils.concatenateStringArrays(args, disabledCommands);
		SpringApplication.run(SimpleArithmeticEvaluator.class, fullArgs);
	}
}
