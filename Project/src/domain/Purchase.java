package domain;


import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Purchase {
	
	
	Date purchaseDate;
	ArrayList<Cart> cart;
	
	
	
	public Purchase(Date purchaseDate, ArrayList<Cart> cart) {
		this.purchaseDate = purchaseDate;
		this.cart = cart;
	}

	public void makePurchase(ArrayList<Cart> cart, Date purchaseDate) {
		
		Cashier cashier = new Cashier();
		cashier.printReceipt(cart, purchaseDate);
	}
	
	public void addToCart(Product p, double quantity) {
		
		Cart c = new Cart(p, quantity);
		cart.add(c);
		
	}
	
	
	
	public static void main(String[] args) {
		
			
			
			
		
//			Calendar cal = Calendar. getInstance();
//			cal. setTime(p.purchaseDate);
//			System.out.println(p.purchaseDate.getDate());
//			String dayWeekText = new SimpleDateFormat("EEEE").format(p.purchaseDate);
//			System.out.println(dayWeekText);
			
			
			Cashier c = new Cashier();
			Food f = new Food();
			Beverage b = new Beverage();
			Clothes cl = new Clothes();
			Appliance a = new Appliance();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date expirationDate1, expirationDate2, productionDate;
			Size m = Size.M;
			
			try {
				expirationDate1 = format.parse("2021-06-14");
				expirationDate2 = format.parse("2022-02-02");
				productionDate = format.parse("2021-03-03");
				
				DateFormat purchaseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date purchaseDate = purchaseFormat.parse("2021-06-14 12:34:56");
				Purchase p = new Purchase(purchaseDate,new ArrayList<Cart>());
				
				p.addToCart(new Food("apples","BrandA",1.50,expirationDate1,purchaseDate),2.45);
				p.addToCart(new Beverage("milk","BrandM",0.99,expirationDate2,purchaseDate),3);
				p.addToCart(new Clothes("T-shirt","BrandT",15.99,m,"violet",purchaseDate),2);
				p.addToCart(new Appliance("laptop","BrandL",2345,"ModelL",productionDate,1.125,purchaseDate),1);
				
				
				p.makePurchase(p.cart,p.purchaseDate);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
	}

}
