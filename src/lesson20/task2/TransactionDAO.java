package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {

        validate(transaction);

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServerException("Not enough space to save transaction");
    }

    private void validate(Transaction transaction) throws BadRequestException {

        int sum = transaction.getAmount();

        if (sum > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");
        }

        int count = 1;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }

        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }

        if (!validateCity(transaction.getCity())) {
            throw new BadRequestException("Transaction city is not allowed " + transaction.getId() + ". Can't be saved");
        }
    }

    Transaction[] transactionList() {
        return transactions;
    }

    Transaction[] transactionList(String city) throws BadRequestException {

        if (city.equals(""))
            throw new BadRequestException("City can't be empty");

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getCity().equals(city))
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getCity().equals(city)) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }

    Transaction[] transactionList(int amount) throws BadRequestException {

        if (amount == 0)
            throw new BadRequestException("Amount can't be zero");

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getAmount() == amount)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getAmount() == amount) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }

    private boolean validateCity(String city) {

        for (String allowedCity : utils.getCities()) {
            if (allowedCity.equals(city))
                return true;
        }

        return false;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }

}
