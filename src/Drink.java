
public abstract class Drink extends Product {

	private int volume;
	
	public Drink(String name, double price, int quantity, int volume) {
		super(name, price, quantity);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public abstract String toString();
}
