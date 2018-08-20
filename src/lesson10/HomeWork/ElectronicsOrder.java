package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String getShipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, getShipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
    }

    private boolean validateCity(String city) {
        return city == "Киев" || city == "Одесса" || city == "Днепр" || city == "Харьков";
    }

    @Override
    public void validateOrder() {
        if (getCustomerOwned() == null || getDateConfirmed() != null)
            return;

        if (validateCity(getShipFromCity()) && validateCity(getShipToCity()) && getBasePrice() > 100 && getCustomerOwned().getGender() == "Женский") {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        if (getCustomerOwned() == null || getTotalPrice() != 0)
            return;

        String shipToCity = getShipToCity();
        double totalPrice = getBasePrice() + getBasePrice() * ((shipToCity == "Киев" || shipToCity == "Одесса") ? 0.1 : 0.15);

        if (getBasePrice() > 1000) {
            totalPrice -= totalPrice * 0.05;
        }

        setTotalPrice(totalPrice);
    }
}