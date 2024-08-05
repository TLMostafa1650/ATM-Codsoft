import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private Bankaccount account;
    private Scanner scanner;

    public ATM(Bankaccount account)
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void Starting()
    {
        boolean Run_Status = true;
        while (Run_Status)
        {
            System.out.println("Hello, Sir! \n Welcome To TLMO'S ATM ! .. How Can We Help You ?");
            ATM_Options();

            int user_choice = scanner.nextInt();

            switch (user_choice)
            {
                case 1:
                    check_balance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    Deposit();
                    break;
                case 4:
                    Run_Status = false;
                    System.out.println("Thank You For Choosing TLMO'S ATM ! \n Have a Good Day & GoodBye :) ");
                    continue;
                default:
                    System.out.println("Invalid Choice ... \n Please Enter From (1 - 4 ) ");
                    continue;
            }
            System.out.print("\n Do you want to perform another operation? \n Press 1 For Yes \n Press 2 For No \n");
            int operation_choice = scanner.nextInt();
            if (operation_choice == 1) {
                // Continue with the loop
                continue;
            } else if (operation_choice == 2) {
                Run_Status = false; // Exit the loop
                System.out.println("Thank You For Choosing TLMO'S ATM! Have a Good Day & Goodbye :)");
            } else {
                System.out.println("Invalid input. Exiting the ATM.");
                Run_Status = false; // Exit the loop for invalid input
            }

        }
    }

    public void ATM_Options()
    {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.println("Please, Enter Your Choice: ");
    }

    public void check_balance()
    {
        System.out.println("Sure ! \n Your Current Balance Is: " + account.getBalance());
    }

    public void withdraw()
    {
        double user_amount;
        System.out.println("Sure ! \n Please Enter The Amount You Want to Withdraw: $");
        user_amount = getValidDoubleInput();
        while (true){
        if (user_amount <= 0)
        {
            System.out.println("Invalid amount ... Please Enter A Postive Number.");

        }
        else if (user_amount > account.getBalance())
        {
            System.out.println("Insufficient funds ... Please enter a smaller amount.");
        }
        else {break;}}
        account.withdraw(user_amount);
        System.out.println("Successfully withdrew " + user_amount + " $");
        System.out.println("Your New Balance Is: " + account.getBalance() + " $");

    }

    public void Deposit()
    {
        double user_amount;
        System.out.println("Sure ! \n Please Enter The Amount You Want To Depoist: $");
        user_amount = getValidDoubleInput();
        while (true){
        if (user_amount <= 0)
        {
            System.out.println("Invalid amount ... Please Enter A Postive Number.");
        }
        else
            break;
        }
        account.deposit(user_amount);
    {
        System.out.println("Successfully Deposited " + user_amount + " $");
        System.out.println("Your New Balance Is: " + account.getBalance() + " $");
    }
    }
    private int getValidIntegerInput() {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input ... Please Enter A Number.");
                scanner.nextLine();
            }
        }
        return input;
    }


    private double getValidDoubleInput() {
        double input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                input = scanner.nextDouble();
                if (input <= 0) {
                    System.out.println("Invalid amount ... Please Enter A Positive Number.");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input ... Please Enter A Valid Number.");
                scanner.nextLine();
            }
        }
        return input;
    }
}
