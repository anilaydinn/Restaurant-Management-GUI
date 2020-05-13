
public class AlcoholDrink extends Drink {

	private double degree;
	
	public AlcoholDrink(String name, double price, int quantity, int volume, double degree) {
		super(name, price, quantity, volume);
		this.degree = degree;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + getVolume() + " " + this.degree;
	}
}
