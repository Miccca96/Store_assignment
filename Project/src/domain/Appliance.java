package domain;


import java.util.Date;
import java.util.GregorianCalendar;

public class Appliance extends Product{
    
    private String model;
    private Date productionDate;
    private double killograms;
    private int discountPercent;
    double discount;
    boolean calculate;

    public Appliance() {
        super();
    }

    public Appliance(String name, String brand, double price,String model, Date productionDate, double killogrmas,Date purchase) {
        super(name,brand,price);
        this.model = model;
        this.productionDate = productionDate;
        this.killograms = killogrmas;
        this.calculate = calculatePrice(purchase);
    }

    public double getKillogrmas() {
        return killograms;
    }

    public void setKillogrmas(double killogrmas) {
        this.killograms = killogrmas;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    

	public boolean isCalculate() {
		return calculate;
	}

	public void setCalculate(boolean calculate) {
		this.calculate = calculate;
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

	@Override
	public boolean calculatePrice(Date purchase) {

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(purchase);
		int day = c.get(GregorianCalendar.DAY_OF_WEEK);
		if((day == 7 || day == 1) && getPrice() > 999) {
			this.discountPercent = 7;
			this.discount = 0.07;
			return true;
		}
		return false;
		
	}}
