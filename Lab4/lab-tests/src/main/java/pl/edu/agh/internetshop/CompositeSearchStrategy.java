package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{
    Collection<SearchStrategy> strategies;

    public CompositeSearchStrategy(){
        this.strategies=new ArrayList<>();
    }

    @Override
    public boolean filter(OrderLog o) {
        boolean flag=true;
        for(SearchStrategy strategy:strategies){
            if (!strategy.filter(o)){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public void addStrategy(SearchStrategy strategy){
        strategies.add(strategy);
    }
}
