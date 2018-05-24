package examples;

import org.springframework.context.ApplicationListener;

public class BlackListEventSubscriber implements ApplicationListener<BlackListEvent> {
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	public void onApplicationEvent(BlackListEvent event) {
		System.out.println("handling blacklist event: " + event);
	}
}
