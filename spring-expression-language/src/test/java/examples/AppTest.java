package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Spring Expression Language Test
 * 
 * @author kimcatt
 * @date 2018年5月27日 下午1:38:19
 * @since JDK 1.7
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
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		NumberGuess numberGuess = ctx.getBean(NumberGuess.class);
		TaxCalculator taxCalculator = ctx.getBean(TaxCalculator.class);
		ShapeGuess shapeGuess = ctx.getBean(ShapeGuess.class);
		System.out.println(numberGuess.getRandomNumber());
		System.out.println(taxCalculator.getDefaultLocale());
		System.out.println(shapeGuess.getInitialShapeSeed());
		assertTrue(true);
	}

	public void testParse() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		String message = (String) exp.getValue();
		assertEquals("Hello World!", message);

		parser = new SpelExpressionParser();
		// invokes 'getBytes()'
		exp = parser.parseExpression("'Hello World'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		assertEquals("Hello World!", new String(message));

		parser = new SpelExpressionParser();
		// invokes 'getBytes()'
		exp = parser.parseExpression("'Hello World'.bytes.length");
		Integer len = (Integer) exp.getValue();
		assertEquals(Integer.valueOf("Hello World".getBytes().length), len);

	}

	public void testParseConstructor() {
		SpelExpressionParser parser = new SpelExpressionParser();
		// invokes 'getBytes()'
		Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
		String message = exp.getValue(String.class);
		assertEquals("HELLO WORLD", message);
	}

	public void testParseProperty() {
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);
		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String name = (String) exp.getValue(tesla);
		// name == "Nikola Tesla"
		exp = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp.getValue(tesla, Boolean.class);
		assertEquals(true, result);
	}

	public void testEvaluationContext() {
		Simple simple = new Simple();
		simple.booleanList.add(true);
		EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		// false is passed in here as a string. SpEL and the conversion service will
		// correctly recognize that it needs to be a Boolean and convert it
		SpelExpressionParser parser = new SpelExpressionParser();
		parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
		// b will be false
		Boolean b = simple.booleanList.get(0);
		assertEquals((Boolean) false, b);
	}

	public void testParserConfiguration() {
		// Turn on:
		// - auto null reference initialization
		// - auto collection growing
		SpelParserConfiguration config = new SpelParserConfiguration(true, true);
		ExpressionParser parser = new SpelExpressionParser(config);
		Expression expression = parser.parseExpression("list[3]");
		Demo demo = new Demo();
		Object o = expression.getValue(demo);
		// demo.list will now be a real collection of 4 entries
		// Each entry is a new empty String
		assertEquals(4, demo.list.size());
	}

	public void testCompilation() {
		SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
				this.getClass().getClassLoader());
		SpelExpressionParser parser = new SpelExpressionParser(config);
		Expression expr = parser.parseExpression("payload");
		MyMessage message = new MyMessage();
		Object payload = expr.getValue(message);
		assertEquals("payload placeholder", String.valueOf(payload));
	}

	public void testTypes() {
		ExpressionParser parser = new SpelExpressionParser();
		Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
		Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);
		boolean trueValue = parser
				.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
				.getValue(Boolean.class);
		assertTrue(trueValue);
	}

	public void testVariables() {
		Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
		EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
		context.setVariable("newName", "Mike Tesla");
		ExpressionParser parser = new SpelExpressionParser();
		parser.parseExpression("Name = #newName").getValue(context, tesla);
		System.out.println(tesla.getName()); // "Mike Tesla"
		assertEquals("Mike Tesla", tesla.getName());
	}

	public void testInlineLists() {
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		// evaluates to a Java list containing the four numbers
		List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
		List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
		System.out.println(numbers.get(0));
		System.out.println(((List) listOfLists.get(0)).get(0));
		assertTrue(true);
	}

	public void testAssignment() {
		Inventor inventor = new Inventor();
		EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
		ExpressionParser parser = new SpelExpressionParser();
		parser.parseExpression("Name").setValue(context, inventor, "Aleksandar Seovic");
		// alternatively
		String aleks = parser.parseExpression("Name = 'Aleksandar Seovic'").getValue(context, inventor, String.class);
		assertEquals(inventor.getName(), "Aleksandar Seovic");
	}

	public void testVariables2() {
		// create an array of integers
		List<Integer> primes = new ArrayList<Integer>();
		primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));
		// create parser and set variable 'primes' as the array of integers
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		context.setVariable("primes", primes);
		// all prime numbers > 10 from the list (using selection ?{...})
		// evaluates to [11, 13, 17]
		List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression("#primes.?[#this>10]")
				.getValue(context);
		System.out.println(Arrays.toString(primesGreaterThanTen.toArray()));
		assertTrue(true);
	}

	class Simple {
		public List<Boolean> booleanList = new ArrayList<Boolean>();
	}

	class Demo {
		public List<String> list;
	}

	class MyMessage {
		public String payload = "payload placeholder";
	}
}
