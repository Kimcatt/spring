package examples;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

public class LifecycleBean implements InitializingBean, DisposableBean {

	private String name;

	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("property setting..");
	}

	public LifecycleBean(String id) {
		super();
		this.id = id;
		System.out.println("constructing..");
	}

	public void destroy() throws Exception {
		System.out.println("destroying..");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("acting after properties set..");

	}

}
