package examples;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Person Validator
 * @author kimcatt
 * @date 2018年5月24日 下午10:05:33
 * @since JDK 1.7
 */
@Component
public class PersonValidator implements Validator {
	/**
	 * This Validator validates *just* Person instances
	 */
	public boolean supports(Class clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "empty name");
		Person p = (Person) obj;
		if (p.getAge() < 0) {
			e.rejectValue("age", "negative age");
		} else if (p.getAge() > 110) {
			e.rejectValue("age", "too old");
		}
	}
}
