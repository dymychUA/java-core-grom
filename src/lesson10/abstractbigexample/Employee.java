package lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positions = new String[10];

    abstract void paySallary();

    void changePosition(String newPosition) {
        savePositionToHistory();
        curPosition = newPosition;
    }

    private void savePositionToHistory() {
        int index = 0;
        for (String pos : positions) {
            if (pos == null) {
                positions[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
