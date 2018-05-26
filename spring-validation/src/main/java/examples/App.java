package examples;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Spring Validation
 * 
 * @author kimcatt
 * @date 2018年5月26日 下午7:41:27
 * @since JDK 1.7
 */
public class App {
	public static void main(String[] args) {

		// Validator validator = Validation
		//      .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
		// Validator validator =
		// Validation.buildDefaultValidatorFactory().getValidator();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Foo>> set = validator.validate(new Foo("lowerCase", "stub"));
		for (ConstraintViolation<Foo> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}
		
		set = validator.validate(new Foo(null, "stub"));
		for (ConstraintViolation<Foo> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}

	}
}
