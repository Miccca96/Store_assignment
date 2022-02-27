package domain;

public class Cart {

	Product p;
	double quantity;
	
	public Cart() {
		
	}
	
	public Cart(Product p, double quantity) {
		this.p = p;
		this.quantity = quantity;
	}
	

	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
