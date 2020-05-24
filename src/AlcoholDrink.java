
public class AlcoholDrink extends Drink {

	private String degree;
	
	public AlcoholDrink(String name, double price, int quantity, int volume, String degree) {
		super(name, price, quantity, volume);
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + getVolume() + " " + this.degree;
	}
}
