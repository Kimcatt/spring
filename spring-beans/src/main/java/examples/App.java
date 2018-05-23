package examples;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PropertyConfigurator.configure(App.class.getClassLoader().getResourceAsStream("log4j.properties"));
		System.out.println("Hello World!");
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		ExampleBean bean = ctx.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean);
		System.out.println(ctx.getBean("exampleBean2", ExampleBean.class));
		System.out.println(ctx.getBean("exampleBean3", ExampleBean.class));
		
		System.out.println(ctx.getBean("foo", Foo.class));
		System.out.println(ctx.getBean("foo2", Foo.class));
		System.out.println(ctx.getBean("bar", Bar.class));
		System.out.println(ctx.getBean("bar2", Bar.class));
		System.out.println(ctx.getBean("lifecycleBean", LifecycleBean.class));
		ctx.registerShutdownHook();
		new Scanner(System.in).nextLine();
	}
}
