package examples;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

/**
 * @author kimcatt
 * @date 2018年5月24日 下午10:05:19
 * @since JDK 1.7
 */
@Component
public class App {
	
	@Autowired(required = true)
	private Person person;
	
	@Autowired(required = true)
	private PersonValidator personValidator; 
	
	public void validate() {
		BindException errors = new BindException(person, "person");
		personValidator.validate(person, errors);
		List<FieldError> fieldErrors = errors.getFieldErrors();
		for (FieldError error : fieldErrors) {
			System.out.println(error.getField() + ":" + error.getRejectedValue() + ":" + error.getCode());
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		App app = ctx.getBean(App.class);
		app.validate();
	}
}
