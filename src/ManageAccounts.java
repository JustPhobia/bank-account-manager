import AccountManager.BankAccount;

import java.util.Scanner;

public class ManageAccounts {
    Scanner  sc = new Scanner(System.in);
    BankAccount savingsAccount =new BankAccount("","","Savings",0);
    BankAccount creditAccount=new BankAccount("","","Cheque",0);
    boolean initiated=false;
    /*
    Part 2: Create the Main Class
In the main method:
1. Create two BankAccount objects with different account types :D
2. Deposit money into at least one account
3. Withdraw money from both accounts (one must fail)
4. Apply monthly fees
5. Print final account details
     */
    void initiateAccount(){
        System.out.println("You don't currently have a savings and cheque account. Please create your accounts");
        savingsAccount.insertDetails();
        creditAccount.insertDetails();
        initiated=true;
    }
    void run(){
        boolean run=true;
        Menu:
        do {
            System.out.println("Which account would you like to open?"+
                    "\n1: Savings"+
                    "\n2: Cheque"+
                    "\n3: Close Application");
            switch (sc.nextInt()){
                case 1:
                    savingsAccount.editAccount();
                    break;
                case 2:
                    creditAccount.editAccount();
                    break;
                case 3:
                    run = false;
                    break;
            }
        }while(run);
    }
    public static void main(String[] args) {
        ManageAccounts manageAccounts = new ManageAccounts();
        if (!manageAccounts.initiated){
            manageAccounts.initiateAccount();
        }
        manageAccounts.run();
    }
}
