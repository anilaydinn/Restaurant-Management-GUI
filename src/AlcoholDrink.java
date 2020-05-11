
public class AlcoholDrink extends Drink {

	private boolean alcohol;
	private double degree;
	
	public AlcoholDrink(String name, double price, int quantity, int volume, boolean alcohol, double degree) {
		super(name, price, quantity, volume);
		this.alcohol = alcohol;
		this.degree = degree;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + getVolume() + " " + this.alcohol + " " + this.degree;
	}
}
