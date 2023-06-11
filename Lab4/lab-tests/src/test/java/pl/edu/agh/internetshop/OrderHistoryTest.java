package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderHistoryTest {
@Test
public void filterTest(){
//given
    SearchStrategy strategy = mock(SearchStrategy.class);
    OrderHistory orderHistory = new OrderHistory(strategy);
    OrderLog orderLog = mock(OrderLog.class);
    OrderLog orderLog2 = mock(OrderLog.class);
    OrderLog orderLog3 = mock(OrderLog.class);
    OrderLog orderLog4 = mock(OrderLog.class);
    ArrayList<OrderLog> orderLogs = new ArrayList<>();
    orderLogs.add(orderLog);
    orderLogs.add(orderLog2);
    orderLogs.add(orderLog3);
    orderLogs.add(orderLog4);

    ArrayList<OrderLog> expected=new ArrayList<>();
    expected.add(orderLog);
    expected.add(orderLog3);

    //when
    when(strategy.filter(orderLog)).thenReturn(true);
    when(strategy.filter(orderLog2)).thenReturn(false);
    when(strategy.filter(orderLog3)).thenReturn(true);
    when(strategy.filter(orderLog4)).thenReturn(false);
    orderHistory.strategy=strategy;
    orderHistory.history=orderLogs;

    ArrayList<OrderLog> result=orderHistory.filter();

    //then
    assertEquals(2,result.size());
    assertEquals(orderLog,result.get(0));
    assertEquals(orderLog3,result.get(1));
}
}
