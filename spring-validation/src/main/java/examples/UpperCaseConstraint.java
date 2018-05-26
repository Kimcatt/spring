package examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpperCaseConstraintValidator.class)
public @interface UpperCaseConstraint {
	
	String field() default "";
	
	String message() default "";

    Class[] groups() default {};

    Class[] payload() default {};
}
