package examples;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;

public class LifecycleBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	private String name;

	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("wiring property..");
	}

	public LifecycleBean(String id) {
		super();
		this.id = id;
		System.out.println("constructing..");
	}

	public void destroy() throws Exception {
		System.out.println("destroying..");

	}
	
	public void init() {
		System.out.println("initializing..");
	}
	
	public void dispose() {
		System.out.println("disposing..");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("acting after properties set..");

	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("wiring application context..");
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("wiring bean factory..");
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	public void setBeanName(String arg0) {
		System.out.println("wiring bean name..");
	}

}
