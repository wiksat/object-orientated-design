package pl.edu.agh.internetshop;

import java.util.Date;

public class OrderLog {
    Order order;
    Date date;

    public OrderLog(Order order){
        this.order=order;
    }
}
