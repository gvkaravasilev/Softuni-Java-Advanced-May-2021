package DefiningClassesLab.BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int currentId = 0;
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {

                case "Create":
                    currentId++;
                    BankAccount bankAccount = new BankAccount();

                    bankAccounts.put(bankAccount.getId(), bankAccount);

                    System.out.printf("Account ID%d created%n", currentId);

                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Integer.parseInt(tokens[2]);


                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int id1 = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (bankAccounts.containsKey(id1)) {
                        System.out.println(bankAccounts.get(id1).getInterest(years));
                    }else{
                        System.out.println("Account does not exist");
                    }


                    break;
            }

            input = scan.nextLine();
        }
        System.out.println();
    }
}
