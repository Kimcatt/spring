package examples;

public class Bar {
	
	private String id;
	
	private String type;

	public Bar(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ",type:" + type;
	}
	
}
