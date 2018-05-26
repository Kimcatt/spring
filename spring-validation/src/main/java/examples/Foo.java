package examples;

import javax.validation.constraints.NotNull;

public class Foo {
	
	@NotNull(message = "x can not be null")
	@UpperCaseConstraint(field = "x", message = "x must be upper case")
	private String x;
	
	private String y;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	public Foo(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x:" + x + ",y:" + y;
	}

}
