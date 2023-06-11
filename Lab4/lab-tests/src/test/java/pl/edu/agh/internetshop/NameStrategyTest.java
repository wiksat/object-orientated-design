package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NameStrategyTest {
    private static final String NAME = "name";
    @Test
    public void testCorrectFilter(){
        //given
        OrderLog orderLog = mock(OrderLog.class);
        orderLog.order = mock(Order.class);
        NameStrategy strategy=new NameStrategy(NAME);

        //when
        when(orderLog.order.getShipment()).thenReturn(mock(Shipment.class));
        when(orderLog.order.getShipment().getRecipientAddress()).thenReturn(mock(Address.class));
        when(orderLog.order.getShipment().getRecipientAddress().getName()).thenReturn(NAME);

        //then
        assertTrue(strategy.filter(orderLog));
    }
    @Test
    public void testUncorrectFilter(){
        //given
        OrderLog orderLog = mock(OrderLog.class);
        orderLog.order = mock(Order.class);
        NameStrategy strategy=new NameStrategy("notname");

        //when
        when(orderLog.order.getShipment()).thenReturn(mock(Shipment.class));
        when(orderLog.order.getShipment().getRecipientAddress()).thenReturn(mock(Address.class));
        when(orderLog.order.getShipment().getRecipientAddress().getName()).thenReturn("otherName");

        //then
        assertFalse(strategy.filter(orderLog));
    }
    @Test
    public void testSetStrategyName(){
        //given
        OrderLog orderLog = mock(OrderLog.class);
        orderLog.order = mock(Order.class);
        NameStrategy strategy=new NameStrategy("notname");

        //when
        when(orderLog.order.getShipment()).thenReturn(mock(Shipment.class));
        when(orderLog.order.getShipment().getRecipientAddress()).thenReturn(mock(Address.class));
        when(orderLog.order.getShipment().getRecipientAddress().getName()).thenReturn(NAME);

        //then
        assertFalse(strategy.filter(orderLog));
        strategy.setName(NAME);
        assertTrue(strategy.filter(orderLog));
    }
}
