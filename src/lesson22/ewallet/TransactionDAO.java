package lesson22.ewallet;

import lesson22.ewallet.exception.BadRequestException;
import lesson22.ewallet.exception.InternalServerException;
import lesson22.ewallet.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];

    public static Transaction save(Transaction transaction) throws Exception {

        validate(transaction);

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServerException("Not enough space to save transaction id: " + transaction.getId());
    }

    private static void validate(Transaction transaction) throws BadRequestException {

        int sum = transaction.getAmount();

        if (sum > Utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");
        }

        int count = 1;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > Utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }

        if (count > Utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }

        if (!validateCity(transaction.getCity())) {
            throw new BadRequestException("Transaction city is not allowed " + transaction.getId() + ". Can't be saved");
        }
    }

    static Transaction[] transactionList() {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                result[index] = transaction;
                index++;
            }
        }

        return result;
    }

    static Transaction[] transactionList(String city) throws BadRequestException {

        /*
        if (!validateCity(city))
            throw new BadRequestException("City is not valid");
        */

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

    static Transaction[] transactionList(int amount) throws BadRequestException {

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

    private static boolean validateCity(String city) {

        for (String allowedCity : Utils.getCities()) {
            if (allowedCity.equals(city))
                return true;
        }

        return false;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);
                int trYear = calendar.get(Calendar.YEAR);

                if (trMonth == month && trDay == day && year == trYear)
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
                int trYear = calendar.get(Calendar.YEAR);

                if (trMonth == month && trDay == day && year == trYear) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }

}
