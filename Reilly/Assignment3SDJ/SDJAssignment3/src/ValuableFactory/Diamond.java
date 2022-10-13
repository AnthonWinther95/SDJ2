package ValuableFactory;

public class Diamond extends Valuable {

	public Diamond(String name, int value) {
		super(name, value);

	}
	
	public String getName() {
		return "Diamond";
	}
	
	public int getValue() {
		
		return 20;
	}

}
