package lesson30.HW;

import java.util.Objects;

public class Customer {

    private String name;
    private String country;
    private int mothlyPay;

    public Customer(String name, String country, int mothlyPay) {
        this.name = name;
        this.country = country;
        this.mothlyPay = mothlyPay;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMothlyPay() {
        return mothlyPay;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", mothlyPay=" + mothlyPay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
