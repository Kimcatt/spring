package com.kimcatt.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kimcatt.spring.helloworld.service.MessagePrinter;

/**
 * Hello world!
 *
 */
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MessagePrinter bean = ctx.getBean(MessagePrinter.class);
		bean.print();
	}
}
