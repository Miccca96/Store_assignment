package domain;

import java.util.Date;
import java.util.GregorianCalendar;

public class Clothes extends Product{
    
    private Enum<Size> size;
    private String color;
    private int discountPercent;
    private double discount;
    private boolean calculate;

    public Clothes() {
        super();
    }

    public Clothes(String name, String brand, double price,Enum<Size> size, String color,Date purchase) {
        super(name,brand,price);
        this.size = size;
        this.color = color;
        this.calculate = calculatePrice(purchase);
    }

    public Enum<Size> getSize() {
        return size;
    }

    public void setSize(Enum<Size> size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(purchase);
		int day = c.get(GregorianCalendar.DAY_OF_WEEK);
		if(day == 3 || day == 4 || day == 5 || day == 6 || day == 7) {
			this.discountPercent = 10;
			this.discount = 0.1;
			return true;
		}
		return false;
		
	}

	

	}
