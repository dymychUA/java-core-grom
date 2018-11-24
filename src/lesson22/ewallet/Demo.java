package lesson22.ewallet;

import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        Transaction tr0 = new Transaction(100, "Kiev", 40, "40 hrn", TransactionType.INCOME, new Date());

        Transaction tr1 = new Transaction(101, "Odessa", 5, "Allo. New phone. 5 hrn", TransactionType.OUTCOME, new Date());
        Transaction tr2 = new Transaction(102, "Kiev", 5, "Allo. New phone. 5 hrn", TransactionType.OUTCOME, new Date());
        Transaction tr3 = new Transaction(103, "Lviv", 20, "Allo. New phone. 20 hrn", TransactionType.OUTCOME, new Date());

        Transaction tr4 = new Transaction(104, "Kiev", 50, "Allo. New phone. 50 hrn", TransactionType.OUTCOME, new Date());
        Transaction tr5 = new Transaction(105, "Kiev", 50, "Allo. New phone. 50 hrn", TransactionType.OUTCOME, new Date());
        Transaction tr6 = new Transaction(106, "Kiev", 50, "Allo. New phone. 50 hrn", TransactionType.OUTCOME, new Date());

        try {
            Controller.save(tr0);
            Controller.save(tr1);
            Controller.save(tr2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(Controller.transactionList()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(Controller.transactionList(5)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(Controller.transactionList("Odessa")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Controller.save(tr3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Controller.save(tr4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
