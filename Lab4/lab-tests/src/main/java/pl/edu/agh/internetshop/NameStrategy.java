package pl.edu.agh.internetshop;

public class NameStrategy implements SearchStrategy{
String lastName;
    public NameStrategy(String name){
        this.lastName=name;
    }
    @Override
    public boolean filter(OrderLog o) {
        return o.order.getShipment().getRecipientAddress().getName().equals(lastName);
    }
    public String getName(){
        return lastName;
    }
    public void setName(String name){
        this.lastName=name;
    }

}
