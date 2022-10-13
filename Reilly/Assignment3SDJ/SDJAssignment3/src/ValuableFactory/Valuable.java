package ValuableFactory;

public class Valuable implements ValuableFactory {

	private String name;
	private int value;
	
	public Valuable(String name, int value) {
		
		this.name = name; 
		this.value = value;
				
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getValue() {
		return value;
	}
}
