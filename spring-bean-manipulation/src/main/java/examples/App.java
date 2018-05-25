package examples;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kimcatt
 * @date 2018年5月25日 下午7:39:13
 * @since JDK 1.7
 */
public class App {
	public static void main(String[] args) {
		BeanWrapper company = new BeanWrapperImpl(new Company());
		// setting the company name..
		company.setPropertyValue("name", "Some Company Inc.");
		// ... can also be done like this:
		PropertyValue value = new PropertyValue("name", "Some Company Inc.");
		company.setPropertyValue(value);
		// ok, let's create the director and tie it to the company:
		BeanWrapper jim = new BeanWrapperImpl(new Employee(10000));
		jim.setPropertyValue("name", "kimcatt zax");
		company.setPropertyValue("managingDirector", jim.getWrappedInstance());
		// retrieving the salary of the managingDirector through the company
		Float salary = (Float) company.getPropertyValue("managingDirector.salary");
		System.out.println(salary);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		DependsOnExoticType dependsOnExoticType = ctx.getBean(DependsOnExoticType.class);
		System.out.println(dependsOnExoticType.getType().getName());
	}
}
