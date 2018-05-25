package examples;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.support.FormattingConversionService;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		FormattingConversionService conversionService = ctx.getBean(FormattingConversionService.class);
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 4, 25, 22, 32, 0);
		Assert.assertEquals("20180525", conversionService.convert(cal.getTime(), String.class));
	}
}
