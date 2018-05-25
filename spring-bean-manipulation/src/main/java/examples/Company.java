package examples;

/**
 * Company 
 * @author kimcatt
 * @date 2018年5月25日 下午7:40:55
 * @since JDK 1.7
 */
public class Company {
	private String name;
	private Employee managingDirector;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManagingDirector() {
		return this.managingDirector;
	}

	public void setManagingDirector(Employee managingDirector) {
		this.managingDirector = managingDirector;
	}
	
	
}
