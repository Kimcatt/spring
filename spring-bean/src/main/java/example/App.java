package example;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PropertyConfigurator.configure(App.class.getClassLoader().getResourceAsStream("log4j.properties"));
		System.out.println("Hello World!");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		ExampleBean bean = ctx.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean);
		System.out.println(ctx.getBean("exampleBean2", ExampleBean.class));
	}
}
