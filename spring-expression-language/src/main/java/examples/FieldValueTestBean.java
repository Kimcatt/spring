package examples;

import org.springframework.beans.factory.annotation.Value;

public class FieldValueTestBean {
	
	@Value("#{ systemProperties['user.region'] }")
	private String defaultLocale;

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public String getDefaultLocale() {
		return this.defaultLocale;
	}
}
