package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompositeSearchStrategyTest {
    @Test
    public void SearchOneFalse(){
        //given
        CompositeSearchStrategy strategy=new CompositeSearchStrategy();
        SearchStrategy strategy1=mock(SearchStrategy.class);
        SearchStrategy strategy2=mock(SearchStrategy.class);
        SearchStrategy strategy3=mock(SearchStrategy.class);
        SearchStrategy strategy4=mock(SearchStrategy.class);
        OrderLog orderLog=mock(OrderLog.class);

        //when
        when(strategy1.filter(orderLog)).thenReturn(true);
        when(strategy2.filter(orderLog)).thenReturn(true);
        when(strategy3.filter(orderLog)).thenReturn(true);
        when(strategy4.filter(orderLog)).thenReturn(false);
        strategy.addStrategy(strategy1);
        strategy.addStrategy(strategy2);
        strategy.addStrategy(strategy3);
        strategy.addStrategy(strategy4);

        //then
        assertFalse(strategy.filter(orderLog));
    }

    @Test
    public void SearchAllTrue(){
        //given
        CompositeSearchStrategy strategy=new CompositeSearchStrategy();
        SearchStrategy strategy1=mock(SearchStrategy.class);
        SearchStrategy strategy2=mock(SearchStrategy.class);
        SearchStrategy strategy3=mock(SearchStrategy.class);
        SearchStrategy strategy4=mock(SearchStrategy.class);
        OrderLog orderLog=mock(OrderLog.class);

        //when
        when(strategy1.filter(orderLog)).thenReturn(true);
        when(strategy2.filter(orderLog)).thenReturn(true);
        when(strategy3.filter(orderLog)).thenReturn(true);
        when(strategy4.filter(orderLog)).thenReturn(true);
        strategy.addStrategy(strategy1);
        strategy.addStrategy(strategy2);
        strategy.addStrategy(strategy3);
        strategy.addStrategy(strategy4);

        //then
        assertTrue(strategy.filter(orderLog));
    }
}
