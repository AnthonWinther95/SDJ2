package ValuableFactory;

public class goldCoin extends Valuable {

	public goldCoin(String name, int value) {
		super(name, value);

	}
	
	public String getName() {
		
		return "goldCoin";
	}
	
	public int getValue() {
		
		return 1;
	}

}
