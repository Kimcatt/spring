package examples;

/**
 * Employee
 * 
 * @author kimcatt
 * @date 2018年5月25日 下午7:40:18
 * @since JDK 1.7
 */
public class Employee {
	private String name;
	private float salary;

	public Employee(float salary) {
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
