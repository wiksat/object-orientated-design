package pl.edu.agh.internetshop;

public class ProductNameStrategy implements SearchStrategy{
    String name;
    public ProductNameStrategy(String name){
        this.name=name;
    }
    @Override
    public boolean filter(OrderLog o) {
        return o.order.getProducts().stream().anyMatch(product -> product.getName().equals(name));
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
