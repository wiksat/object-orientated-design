package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class OrderHistory {
    Collection<OrderLog> history;
    SearchStrategy strategy;

    public OrderHistory(SearchStrategy strategy){
        this.strategy=strategy;
        history=new LinkedList<>();
    }

    public Collection<OrderLog> getHistory() {
        return history;
    }
    public void addLog(OrderLog log){
        history.add(log);
    }
    public SearchStrategy getStrategy(){
        return strategy;
    }
    public void setStrategy(SearchStrategy strategy){
        this.strategy=strategy;
    }
    public ArrayList<OrderLog> filter (){
        ArrayList<OrderLog> result=new ArrayList<>();
        for(OrderLog log:history){
            if(strategy.filter(log)){
                result.add(log);
            }
        }
        return result;
    }
}
