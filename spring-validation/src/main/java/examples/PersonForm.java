package examples;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {
	
	@NotNull
	@Size(max = 64)
	private String name;
	@Min(0)
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

	public PersonForm(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public PersonForm() {
		super();
	}

}