package lesson22.ewallet;

import lesson22.ewallet.exception.BadRequestException;

public class Controller {

    public static Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) throws BadRequestException {
        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) throws BadRequestException {
        return TransactionDAO.transactionList(amount);
    }

}
