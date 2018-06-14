package examples;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import examples.service.FooService;

/**
 * Aspect Oriented Programming with Spring
 * @author kimcatt
 * @date 2018年5月27日 下午7:20:03
 * @since JDK 1.7
 */
public class Boot {
	public static void main(String[] args) {
		BeanFactory ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		FooService foo = (FooService) ctx.getBean("fooService");
		foo.getFoo("Pengo", 12);
	}
}
