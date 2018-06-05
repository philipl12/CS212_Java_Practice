import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Bank2 {
    private static ArrayList <BankAccount2> accounts = new ArrayList<>();
    private static String name;
    private static int numAccounts = 0;



    public static BankAccount2 getAccount(String userName, int pin) {
        for (int i = 0; i < numAccounts; i++){
            if (accounts.get(i) != null ) {
                if (accounts.get(i).getUserName().equals(userName) &&
                    accounts.get(i).getPIN() == (pin) ) {
                    return accounts.get(i);
                }
            }
        }
        return null;
    }

    public static boolean registerAccount(BankAccount2 account) {
        if (Bank2.accountExists(account.getUserName())) {
                return false;
        }
            accounts.add(account);
            numAccounts++;
            return true;
    }//end registerAccount

    public static void terminateAccount(String userName, int pin) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts.get(i).getUserName().equals(userName)) {
                if (pin == accounts.get(i).getPIN()) {
                    for (int j = 0; j < numAccounts; j++) {
                        if (accounts.get(j).getUserName().equals(userName)) {
                            accounts.remove(j);
                            numAccounts--;
                            break;
                        }
                    }
                }
            }
        }
    }//end terminateAccount

    public static boolean accountExists(String userName) {
        for (int i = 0; i < numAccounts; i++){
            if (accounts.get(i).getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }//end accountExists

    public static void writeToFile(PrintWriter textName) {
        Scanner in = new Scanner(System.in);
        String userName = "";
        int pin = 0000;
        BankAccount2 BA;


        System.out.println("Please enter a username:");
        userName = in.next();
        System.out.println("Please enter a 4 digit pin:");
        pin = in.nextInt();


        BA = Bank2.getAccount(userName, pin);

        if (BA == null) {
            System.out.println("Account doesn't exist...good bye");
        }

        else if (BA != null) {
            String fn = BA.getFirstName();
            String ln = BA.getLastName();
            String address = BA.getAddress();
            String un = BA.getUserName();
            int getPin = BA.getPIN();
            int balance = BA.getBalance();
            BA.writeToFile(textName, fn, ln, address, un, getPin, balance);
        }

    }//end writeToFile

    public static void readFromFile(Scanner scannedName) {
        try {
            while (scannedName.hasNextLine()) {
                BankAccount2 account = new BankAccount2(scannedName);
                Bank2.registerAccount(account);
            }
        }
        catch (Exception e) {
            System.out.println("Nothing here to see");
        }
    }//end readFromFile
}
