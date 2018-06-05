import java.util.Scanner;

public class BankMenu {

    static void landingMenu() {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        String inputNum;
        while (!exit) {
            System.out.print("Please select an option:\n" +
                             "1. Log in\n" +
                             "2. Sign up\n" +
                             "3. Terminate account\n" +
                             "4. Exit\n");
            inputNum = in.nextLine();

            switch (inputNum.trim()) {
                case "1": loginMenu();
                    break;
                case "2": signUpMenu();
                    break;
                case "3": terminateAccountMenu();
                    break;
                case "4": exit = true;
                    break;
                default: System.out.println("Invalid input!");
            }
        }
        System.out.println("Good bye");
        System.exit(0);
    }

    private static void loginMenu() {

        Scanner in = new Scanner(System.in);
        String userName = "";
        int pin = 0000;
        boolean redo;
        int id;
        BankAccount BA;

        redo = false;

        while (!redo) {
            System.out.println("Please enter a username:");
            userName = in.next();
            redo = BankAccount.isValidUserName(userName);
        }

        redo = false;

        while (!redo) {
            System.out.println("Please enter a 4 digit pin:");
            pin = in.nextInt();
            redo = BankAccount.isValidPIN(pin);
        }

        BA = Bank.getAccount(userName, pin);

        if (BA != null) {
            System.out.println( "Welcome Back " +
                    BA.getFirstName() + " " +
                    BA.getLastName() + "\n" );
            mainMenu(BA);
        }

    }

    private static void signUpMenu() {
        Scanner in = new Scanner(System.in);
        boolean redo = false;
        String firstName = "", lastName = "", userName = "", address="";
        int balance = 0, pin = 0;

        while (!redo) {
            System.out.println("Please enter your first name:");
            firstName = in.next();
            redo = BankAccount.isValidName(firstName);
        }
        redo = false;

        while (!redo) {
            System.out.println("Please enter your last name:");
            lastName = in.next();
            redo = BankAccount.isValidName(lastName);
        }

        System.out.println("Please enter your address:");
        Scanner addressVar = new Scanner(System.in);
        address = addressVar.nextLine();

        redo = false;

        while (!redo) {
            System.out.println("Please enter a username:");
            userName = in.next();
            redo = BankAccount.isValidUserName(userName);
        }

        redo = false;

        while (!redo) {
            System.out.println("Please enter a 4 digit pin:");
            pin = in.nextInt();
            redo = BankAccount.isValidPIN(pin);
        }

        System.out.print("\n\n\n\n");

        BankAccount account = new BankAccount(firstName, lastName, userName,
                                              address, balance, pin);
        

        if (Bank.registerAccount(account)) {
            System.out.println("Account " + account.getUserName() +
                               " Created\n\n\n");
        } else {
            System.out.println("Username taken. Account NOT created \n\n\n");
        }

        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();

        landingMenu();

    }
    //end of signUpMenu




    private static void terminateAccountMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please re-enter your username:");
        String userName = in.next();
        System.out.println("Enter PIN");
        int pin = in.nextInt();
        System.out.print("Are you sure you want to terminate your account? [Y/N]");
        String answer = in.next().toLowerCase();
        if (answer.equals("y")) {
            Bank.terminateAccount(userName, pin);
        }

    }//end terminateAccountMenu




    public static void mainMenu(BankAccount BA) {

        Scanner in = new Scanner(System.in);

        boolean exit = false;
        String inputNum;
        while (!exit) {
            System.out.print("Account " + BA.getUserName() +
                             "\n"+"Please select an option:\n" +
                             "1. Deposit money\n" +
                             "2. Withdraw money\n" +
                             "3. Account details\n" +
                             "4. Exit\n");
            inputNum = in.nextLine();

            switch (inputNum.trim()) {
                case "1": depositMenu(BA);
                break;
                case "2": withdrawMenu(BA);
                break;
                case "3": accountMenu(BA);
                break;
                case "4": landingMenu();
                break;
                default: System.out.println("Invalid input!");

            }
        }
        System.out.print("Main menu\n");

    }//end mainMenu




    public static void depositMenu(BankAccount BA) {
        Scanner in = new Scanner(System.in);
        int newAmount = -1;
        while (newAmount <= 0) {
            System.out.println("How much would you like to deposit?");
            newAmount = in.nextInt();
        }
        BA.addBalance(newAmount);

        System.out.print("\nYour Account Balance" +
                        "\n  Balance: " + BA.getBalance() +
                        "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }//end depositMenu




    public static void withdrawMenu(BankAccount BA) {

        Scanner in = new Scanner(System.in);
        int newAmount = -1;
        while (newAmount <= 0) {
            System.out.println("How much would you like to withdraw?");
            newAmount = in.nextInt();
        }
        BA.subtractBalance(newAmount);

        System.out.print("\nYour Account Balance" +
                         "\n  Balance: " + BA.getBalance() +
                         "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }//end withdrawMenu





    public static void accountMenu(BankAccount BA) {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        String inputNum;

        System.out.print("\nYour Account Details" +
                         "\n  First name: " + BA.getFirstName() +
                         "\n  Last name: " + BA.getLastName() +
                         "\n  Address: " + BA.getAddress() +
                         "\n  Username: " + BA.getUserName() +
                         "\n  PIN: " + BA.getPIN() +
                         "\n  Balance: " + BA.getBalance() +
                         "\n\nPress \"Enter\" to continue.");
        in.nextLine();

        while (!exit) {
            System.out.print("Please select option:\n" +
                             "1. Change First Name\n" +
                             "2. Change Last Name\n" +
                             "3. Change Address\n" +
                             "4. Change Username\n" +
                             "5. Change PIN\n" +
                             "6. Exit\n");
            inputNum = in.nextLine();

            switch (inputNum.trim()) {
                case "1": changeFirstNameMenu(BA);
                    break;
                case "2": changeLastNameMenu(BA);
                    break;
                case "3": changeAddressMenu(BA);
                    break;
                case "4": changeUsernameMenu(BA);
                    break;
                case "5": changePINMenu(BA);
                    break;
                case "6": mainMenu(BA);
                    break;
                default: System.out.println("Invalid input!");
            }
        }

    }




    public static void changeFirstNameMenu(BankAccount BA) {
        Scanner in = new Scanner(System.in);
        boolean redo = false;
        String firstName = "";

        while (!redo) {
            System.out.println("Please enter your first name:");
            firstName = in.next();
            redo = BankAccount.isValidName(firstName);
        }

        BA.setFirstName(firstName);

        System.out.print("\nYour First Name has been changed to " +
                         BA.getFirstName() + "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }




    public static void changeLastNameMenu(BankAccount BA) {
        Scanner in = new Scanner(System.in);
        boolean redo = false;
        String lastName = "";

        while (!redo) {
            System.out.println("Please enter your last name:");
            lastName = in.next();
            redo = BankAccount.isValidName(lastName);
        }

        BA.setLastName(lastName);

        System.out.print("\nYour Last Name has been changed to " +
                         BA.getLastName() + "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }




    public static void changeAddressMenu(BankAccount BA) {
        String address;

        System.out.println("Please enter your address:");
        Scanner addressVar = new Scanner(System.in);
        address = addressVar.nextLine();

        BA.setAddress(address);

        System.out.print("\nYour Address has been changed to " +
                         BA.getAddress() + "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }



    public static void changeUsernameMenu(BankAccount BA) {

        Scanner in = new Scanner(System.in);
        boolean redo = false;
        String userName = "";

        while (!redo) {
            System.out.println("Please enter your username:");
            userName = in.next();
            redo = BankAccount.isValidUserName(userName);
            if ( redo ){
                if( Bank.accountExists(userName) ) {
                    redo = false;
                    System.out.print("\nYour USERNAME is Taken\n\n");
                }
            }
        }

        BA.setUserName(userName);

        System.out.print("\nYour USERNAME has been changed to " +
                         BA.getUserName() + "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }




    public static void changePINMenu(BankAccount BA) {
        Scanner in = new Scanner(System.in);
        boolean redo = false;
        int pin = 0;

        while (!redo) {
            System.out.println("Please enter a 4 digit pin:");
            pin = in.nextInt();
            redo = BankAccount.isValidPIN(pin);
        }
        BA.setPIN(pin);

        System.out.print("\nYour PIN has been changed to " +
                         BA.getPIN() + "\n\n");
        System.out.println("Press Enter to Continue.");
        Scanner enterVar = new Scanner(System.in);
        enterVar.nextLine();
        mainMenu(BA);
    }

}
