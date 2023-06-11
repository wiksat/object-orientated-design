package pl.edu.agh.internetshop;

public class OrderPriceStrategy implements SearchStrategy{
    double price;
    public OrderPriceStrategy(double price){
        this.price=price;
    }
    @Override
    public boolean filter(OrderLog o) {
        return o.order.getPrice().equals(price);
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
}
