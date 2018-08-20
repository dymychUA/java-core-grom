package lesson8.accounts;

public class Account {
    String bankNname;
    String ownerName;
    int moneyAmount;

    public Account(String bankNname, String ownerName, int moneyAmount) {
        this.bankNname = bankNname;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void depositMoney(int amount) {
        moneyAmount += amount;
    }

    //overloading
    void depositMoney() {
        moneyAmount += 100;
        System.out.println("deposit was successful");
    }

    void changeOwnerName(String newOwnerName) {
        ownerName = newOwnerName;
    }
}
