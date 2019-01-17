package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        withdrawFromUserBalance(user, amount);
        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency() || !checkWithdraw(fromUser, amount) || !checkFunding(toUser, amount))
            return;

        withdrawFromUserBalance(fromUser, amount);
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        if (!checkFunding(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc");
    }

    private boolean checkFunding(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkWithdraw(User user, int amount) {
        double amountWithCommission = amount + amount * user.getBank().getCommission(amount);
        if (amountWithCommission > user.getBank().getLimitOfWithdrawal() || amountWithCommission > user.getBalance()) {
            printWithdrawErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printFundingErrorMsg(int amount, User user) {
        System.out.println("Can't fund money " + amount + " for user " + user.toString());
    }

    private void printWithdrawErrorMsg(int amount, User user) {
        System.out.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private void withdrawFromUserBalance(User user, int amount) {
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, "sdsdc");
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}