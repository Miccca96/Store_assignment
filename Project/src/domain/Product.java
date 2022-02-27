package domain;

import java.util.ArrayList;
import java.util.Date;

public abstract class Product {
    
    String name;
    String brand;
    double price;
    double quantity;
    ArrayList<Product> cart = new ArrayList<Product>();
 

    public Product() {
    }

    public ArrayList<Product> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}


	public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract boolean calculatePrice(Date purchase);

    

}