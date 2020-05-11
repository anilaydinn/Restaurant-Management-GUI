
public class Food extends Product {
	
	private boolean isVeg;
	private int gram;
	
	public Food(String name, double price, int quantity, boolean isVeg, int gram) {
		super(name, price, quantity);
		this.isVeg = isVeg;
		this.gram = gram;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public int getGram() {
		return gram;
	}

	public void setGram(int gram) {
		this.gram = gram;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getPrice() + " " + getQuantity() + " " + this.gram + " " + this.isVeg;
	}
}
