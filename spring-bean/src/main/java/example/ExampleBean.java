package example;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ExampleBean {

	private static Logger log = Logger.getLogger(ExampleBean.class);

	// Number of years to calculate the Ultimate Answer
	private int years;
	// The Answer to Life, the Universe, and Everything
	private String ultimateAnswer;

	public ExampleBean(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getUltimateAnswer() {
		return ultimateAnswer;
	}

	public void setUltimateAnswer(String ultimateAnswer) {
		this.ultimateAnswer = ultimateAnswer;
	}

	@Override
	public String toString() {
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			return om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			log.error(e);
		}
		return null;
	}
}
