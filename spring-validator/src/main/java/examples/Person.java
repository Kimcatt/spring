package examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kimcatt
 * @date 2018年5月24日 下午10:05:27
 * @since JDK 1.7
 */
@Component
public class Person {

	@Value("kimcatt")
	private String name;
	
	@Value("#{999}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}