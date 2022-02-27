package domain;

import java.util.ArrayList;
import java.util.Date;

public class Cashier {
	

	
	public void printReceipt(ArrayList<Cart> cart, Date purchaseDate) {
		
		CustomerBill cb = new CustomerBill(cart,purchaseDate);
		
	}
}
