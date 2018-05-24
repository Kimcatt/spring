package examples;

public class Foo {
	private String x;
	
	private String y;
	
	public Foo() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "hash:" + this.hashCode() +",x:" + x + ",y:" + y;
	}
	
	
}
