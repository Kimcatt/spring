package examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kimcatt
 * @date 2018年5月24日 下午8:45:18
 * @since JDK 1.7
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		EmailService es = ctx.getBean(EmailService.class);
		es.sendEmail("known.spammer@example.org", "remarks");
		es.sendEmail("kimcatt@example.org", "remarks");
		es.sendEmail("john.doe@example.org", "remarks");
		es.sendEmail("john.doe@example.org", "foo");
//		new Scanner(System.in).nextLine();
	}
}
