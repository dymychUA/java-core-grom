package lesson30.task1;

public class Main {
    public static void main(String[] args) {

        Bank usBank1 = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        User user1 = new User(1001, "Den", 12000, 40, "GMD", 1500, usBank1);
        Bank usBank2 = new USBank(2222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        User user2 = new User(1002, "Bill", 13000, 40, "Google", 1600, usBank2);

        Bank euBank1 = new EUBank(3222, "Sweden", Currency.EUR, 100, 1500, 4, 444343434);
        User user3 = new User(1003, "Ralf", 14000, 40, "Volvo", 1600, euBank1);
        Bank euBank2 = new EUBank(4222, "Sweden", Currency.EUR, 100, 1500, 4, 444343434);
        User user4 = new User(1004, "Gregor", 15000, 40, "Wind", 1700, euBank2);

        Bank chBank1 = new ChinaBank(5222, "China", Currency.USD, 100, 1600, 4, 444343434);
        User user5 = new User(1005, "Li Young", 16000, 40, "Li Co", 1800, chBank1);
        Bank chBank2 = new ChinaBank(6222, "China", Currency.USD, 100, 1600, 4, 444343434);
        User user6 = new User(1006, "Lu Peng", 17000, 40, "Huawei", 1900, chBank2);


        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(user1, 1000);
        bankSystem.withdraw(user2, 250);
        bankSystem.withdraw(user3, 350);
        bankSystem.withdraw(user4, 450);
        bankSystem.withdraw(user5, 550);
        bankSystem.withdraw(user6, 650);

        bankSystem.fund(user1, 1000);
        bankSystem.fund(user2, 2000);
        bankSystem.fund(user3, 3000);
        bankSystem.fund(user4, 4000);
        bankSystem.fund(user5, 5000);
        bankSystem.fund(user6, 6000);

        bankSystem.transferMoney(user1, user2, 100);
        bankSystem.transferMoney(user3, user4, 2500);
        bankSystem.transferMoney(user5, user6, 3500);

        bankSystem.paySalary(user1);
        bankSystem.paySalary(user2);
        bankSystem.paySalary(user3);
        bankSystem.paySalary(user4);
        bankSystem.paySalary(user5);
        bankSystem.paySalary(user6);

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        System.out.println(user4.toString());
        System.out.println(user5.toString());
        System.out.println(user6.toString());

    }
}
