package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
    private double discount;
	
    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount=0;
    }

    public String getName() {
        return name;
    }

    public void setDiscount(double discount){
        this.discount=discount;
    }
    public double getDiscount(){
        return discount;
    }
    public BigDecimal getPriceWithoutDiscount() {
        return price;
    }
    public BigDecimal getPrice() {
        return price.multiply(BigDecimal.valueOf(1-discount));
    }
//    public BigDecimal getPriceWithDiscount(){
//        return price.multiply(BigDecimal.valueOf(1-discount));
//    }
}
