package examples;

import org.springframework.context.event.EventListener;

public class ConditionalBlackListEventSubscriber {
	
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	@EventListener(condition = "#blEvent.test == 'foo'")
	public void processBlackListEvent(BlackListEvent blEvent) {
		System.out.println("conditional black list event subscriber handling black list event: " + blEvent);
	}
}
