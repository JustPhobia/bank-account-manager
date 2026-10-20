package AccountManager;

import java.util.Scanner;

/*
- deposit(double amount): Reject zero or negative deposits
- withdraw(double amount): Allow only if sufficient funds are available
- applyMonthlyFee(): Savings = R10, Cheque = R25
- getBalance(): Returns current balance
- toString(): Returns readable account summary
 */
public class BankAccount {
    Scanner sc = new Scanner(System.in);
    String accountNumber;
    String accountHolder;
    String accountType;
    double balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String accountHolder, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        if (balance < 0) {
            System.out.println("You cannot insert a negative amount, your account has been defaulted to R0.00");
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
        }else{
            System.out.println("Insufficient Funds.");
        }
    }

    public String getType() {
        return this.accountType;
    }

    public void applyMonthlyFee() {
        if (accountType.equals("Savings")) {
            this.balance -= 10;
        } else if (accountType.equals("Cheque")) {
            this.balance -= 25;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String toString() {
        return ("|\t Account Number: " + this.accountNumber
                + "\t| Account Holder: " + this.accountHolder
                + "\t| Account Type: " + this.accountType
                + "\t| Balance: R" + this.balance + " |");
    }

    public void insertDetails() {
        String name, surname;
        StringBuilder tempAccountHolder = new StringBuilder();
        StringBuilder tempAccountNumber = new StringBuilder();
        double amount;
        do{
            tempAccountNumber.delete(0, tempAccountNumber.length());
            System.out.print("Please enter "+accountType+" account number (5 Numbers): ");
            tempAccountNumber.append(sc.nextLine().trim());
        }while (tempAccountNumber.length() != 5);

        System.out.print("Please enter your name: ");
        name = sc.nextLine().trim();
        System.out.print("Please enter your surname: ");
        surname = sc.nextLine().trim();
        tempAccountHolder.append(name).append(" ").append(surname);

        System.out.println("Please add to your "+accountType+" account balance: ");
        amount = sc.nextDouble();
        this.accountNumber = tempAccountNumber.toString();
        if (amount>0) {
            this.balance = amount;
        }else{
            System.out.println("You cannot use a negative amount. Your account has been defaulted to R0.00");
            this.balance = 0.00;
        }
        this.accountHolder = tempAccountHolder.toString();

        tempAccountNumber.delete(0, tempAccountNumber.length());
    }

    public void editAccount() {
        boolean running = true;
        do {
            System.out.println("[Current Account: "+ this.accountType+ " of "+this.accountHolder+"]");
            System.out.println("Please select an option for your " + getType() + ":" +
                    "\n1: Deposit" +
                    "\n2: Withdraw" +
                    "\n3: Monthly Fees" +
                    "\n4: Print Balance" +
                    "\n5: Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    System.out.printf("Old balance:  R%,.2f%n", this.balance);
                    deposit(depositAmount);
                    System.out.printf("New balance:  R%,.2f%n",this.balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    System.out.printf("Old balance:  R%,.2f%n", this.balance);
                    withdraw(withdrawAmount);
                    System.out.printf("New balance:  R%,.2f%n",this.balance);
                    break;
                case 3:
                    applyMonthlyFee();
                    System.out.printf("Monthly fee applied to account, new balance:  R%,.2f%n", this.balance);
                    break;
                case 4:
                    System.out.println(toString());
                    break;
                case 5:
                    running = false;
                    break;
            }
            System.out.println();

        } while (running);
    }
}
