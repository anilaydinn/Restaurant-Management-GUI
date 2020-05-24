
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
	
	public String hot() {
		
		if(this.hot) {
			return "Sıcak";
		}
		else {
			return "Soğuk";
		}
	}

	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + getVolume() + " " + hot();
	}
}
