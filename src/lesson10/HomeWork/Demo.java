package lesson10.HomeWork;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Оля", "Днепр", "Женский");
        Customer customer2 = new Customer("Света", "Харьков", "Женский");
        Customer customer3 = new Customer("Таня", "Херсон", "Женский");
        Customer customer4 = new Customer("Женя", "Киев", "Мужской");
        Customer customer5 = new Customer("Вася", "Одесса", "Мужской");
        Customer customer6 = new Customer("Игорь", "Львов", "Мужской");

        ElectronicsOrder eOrder1 = new ElectronicsOrder("HP Probook H1", new Date(), "Киев", "Днепр", 15000, customer1, 12);
        ElectronicsOrder eOrder2 = new ElectronicsOrder("Asus Zenbook 13", new Date(), "Киев", "Харьков", 12000, customer2, 12);

        FurnitureOrder fOrder1 = new FurnitureOrder("Shlak 1", new Date(), "Львов", "Одесса", 1500, customer5, "AA090");
        FurnitureOrder fOrder2 = new FurnitureOrder("Shlak 2", new Date(), "Львов", "Львов", 200, customer6, "GP830");

        Order[] orders = {eOrder1, eOrder2, fOrder1, fOrder2};

        //*************************** TESTS ******************************
        int i = 1;
        for (Order order : orders) {
            System.out.println();
            System.out.println("    -Order #" + i + " (" + getOrderType(order) +  "):");
            System.out.println(order);
            order.calculatePrice();
            System.out.println("After price calculating");
            System.out.println(order);
            order.validateOrder();
            System.out.println("After validation");
            System.out.println(order);
            order.confirmShipping();
            System.out.println("After shipping confirming");
            System.out.println(order);
            i++;
        }

        //re-validate order
        //pause (Thread.sleep(3000))
        System.out.println();
        System.out.println(new Date());
        eOrder1.validateOrder();
        System.out.println(eOrder1);

        //if customer is null
        System.out.println();
        System.out.println("user = null");
        ElectronicsOrder eOrder = new ElectronicsOrder("HP Probook H1", new Date(), "Киев", "Днепр", 15000, null, 12);
        System.out.println(eOrder);
        eOrder.calculatePrice();
        eOrder.validateOrder();
        eOrder.confirmShipping();
        System.out.println(eOrder);

    }

    private static String getOrderType(Order order) {
        if (order instanceof ElectronicsOrder)
            return "Electronics";
        if (order instanceof FurnitureOrder)
            return "Furniture";
        return "unknown type";
    }
}
