package DefiningClassesLab.BankAccount;

public class BankAccount {


    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private int bankAccountsCount = 1;
    private int id;
    private double balance;

    BankAccount(){
        this.id = bankAccountsCount++;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static double getDEFAULT_INTEREST_RATE() {
        return DEFAULT_INTEREST_RATE;
    }

    public int getBankAccountsCount() {
        return bankAccountsCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBankAccountsCount(int bankAccountsCount) {
        this.bankAccountsCount = bankAccountsCount;
    }

    public static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }
    public void deposit(double amount){
        this.balance += amount;
    }

}
