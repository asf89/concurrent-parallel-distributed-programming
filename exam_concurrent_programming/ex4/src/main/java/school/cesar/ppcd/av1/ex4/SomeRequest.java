package school.cesar.ppcd.av1.ex4;

public class SomeRequest {
	private String data;

	public SomeRequest(){};

	public SomeRequest(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public String toString() {
		return "SomeRequest [data=" + data + "]";
	}
	
}
