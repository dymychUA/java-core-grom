package lesson6;

import java.util.Date;

//for lesson 07
public class DemoHomeWork {
    public static void main(String[] args) {

    }

    Order createOrder() {
        return new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }

    Order createOrderAndCallMethods() {
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");

        order.confirmOrder();
        boolean checked = order.checkPrice();
        boolean isValid = order.isValidType();

        return order;
    }
}
