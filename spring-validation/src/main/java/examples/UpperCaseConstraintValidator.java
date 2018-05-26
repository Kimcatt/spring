package examples;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpperCaseConstraintValidator implements ConstraintValidator<UpperCaseConstraint, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || value.equals(value.toUpperCase());
	}

	public void initialize(UpperCaseConstraint constraint) {
		
	}

}
