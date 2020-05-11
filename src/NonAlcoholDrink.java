
public class NonAlcoholDrink extends Drink {

	private boolean hot;
	
	public NonAlcoholDrink(String name, double price, int quantity, int volume, boolean hot) {
		super(name, price, quantity, volume);
		this.hot = hot;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + getVolume() + " " + this.hot;
	}
}
