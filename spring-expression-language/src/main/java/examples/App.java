package examples;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Spring Expression Language
 * @author kimcatt
 * @date 2018年5月27日 下午1:37:47
 * @since JDK 1.7
 */
public class App {
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		String expStr = "'<strong>Hello World</strong>'";
		Expression exp = parser.parseExpression(expStr);
		String message = (String) exp.getValue();
		System.out.println(message);
		expStr = "'Hello World'";
		exp = parser.parseExpression(expStr);
		message = (String) exp.getValue();
		System.out.println(message);
	}
}
