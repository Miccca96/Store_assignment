package domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Food extends Product{
   
   
   private Date expirationDate;
   private int discountPercent;
   private double discount;
   private boolean calculate;

   public Food() {
       super();
   }

   public Food(String name, String brand, double price, Date expirationDate, Date purchase) {
       super(name,brand,price);
       this.expirationDate = expirationDate;
       this.calculate = calculatePrice(purchase);
   }

   public Date getExpirationDate() {
       return expirationDate;
   }

   public void setExpirationDate(Date expirationDate) {
       this.expirationDate = expirationDate;
   }
   

public int getDiscountPercent() {
	return discountPercent;
}

public void setDiscountPercent(int discountPercent) {
	this.discountPercent = discountPercent;
}

public double getDiscount() {
	return discount;
}

public void setDiscount(double discount) {
	this.discount = discount;
}

public boolean isCalculate() {
	return calculate;
}

public void setCalculate(boolean calculate) {
	this.calculate = calculate;
}

@Override
public boolean calculatePrice(Date purchase) {
	
	Calendar expiration = Calendar.getInstance();
	expiration.setTime(getExpirationDate());
	expiration.set(Calendar.HOUR_OF_DAY, 0);
	expiration.set(Calendar.MINUTE, 0);
	expiration.set(Calendar.SECOND, 0);
	expiration.set(Calendar.MILLISECOND, 0);

	
	
	Calendar current = Calendar.getInstance();
	
	current.setTime(purchase);
	current.set(Calendar.HOUR_OF_DAY, 0);
    current.set(Calendar.MINUTE, 0);
    current.set(Calendar.SECOND, 0);
    current.set(Calendar.MILLISECOND, 0);

	
    
	Calendar cal = Calendar.getInstance();
	cal.setTime(purchase);
	cal.add(Calendar.DAY_OF_MONTH, 5);
	cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
  
    
    
    
    if(current.after(expiration)) {
    	System.out.println("Item has expired");
    	return false;
    }
    
	if((cal.after(expiration) || cal.equals(expiration)) && !current.equals(expiration)) {
		this.discountPercent = 30;
		this.discount = 0.3;
		return true;
	}
		
	if(current.equals(expiration)) {
		this.discountPercent = 70;
		this.discount = 0.7;
		return true;
	}
	return false;
	
	
	
}


	
}
