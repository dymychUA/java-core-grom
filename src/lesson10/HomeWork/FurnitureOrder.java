package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String getShipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, getShipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    public String getFurnitureCode() {
        return furnitureCode;
    }

    private boolean validateCity(String city) {
        return city == "Киев" || city == "Львов";
    }

    @Override
    public void validateOrder() {
        if (getCustomerOwned() == null || getDateConfirmed() != null)
            return;

        if (validateCity(getShipFromCity()) && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест") {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        if (getCustomerOwned() == null || getTotalPrice() != 0)
            return;

        setTotalPrice(getBasePrice() + getBasePrice() * (getBasePrice() < 5000 ? 0.05 : 0.02));
    }
}
