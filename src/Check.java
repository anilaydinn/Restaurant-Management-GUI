import java.util.ArrayList;
import java.util.List;

public class Check {

	private ArrayList<Product> check;
	private double totalPrice;
	
	public Check(){}
	
	public void addItem(Product product) {
		check.add(product);
	}
	
	public void calcTotalPrice() {
		for(Product p : check) {
			totalPrice += p.getQuantity() * p.getPrice();
		}
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public void removeAll() {
		for(Product p : check) {
			check.remove(p);
		}
	}
	
	public void showProducts() {
		for(Product p : check) {
			System.out.println(p.toString());
		}
	}
	
	public List<Product> getProducts(){
		return this.check;
	}
}
