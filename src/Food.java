
public class Food extends Product {
	
	private boolean isVeg;
	
	public Food(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	
	public Food(String name, double price, int quantity, boolean isVeg) {
		super(name, price, quantity);
		this.isVeg = isVeg;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}
	
	
	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + isVeg() ;
	}
}
