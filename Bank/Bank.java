import java.util.Scanner;

public class Bank {
    private static BankAccount[] accounts = new BankAccount[10];
    private static String name;
    private static int numAccounts = accounts.length;



    public static BankAccount getAccount(String userName, int pin) {
        for (int i = 0; i < numAccounts; i++){
            if (accounts[i] != null ) {
                if (accounts[i].getUserName().equals(userName) &&
                    accounts[i].getPIN() == (pin) ) {
                    return accounts[i];
                }
            }
        }
        return null;
    }

    public static boolean registerAccount(BankAccount account) {
        for (int i = 0; i < numAccounts; i++){
            if (accounts[i] == null ) {
                accounts[i] = account;
                return true;
            } else if (Bank.accountExists(account.getUserName()) ) {
                return false;
            }
        }
        return false;
    }


    public static void terminateAccount(String userName, int pin) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getUserName().equals(userName)) {
                if (pin == accounts[i].getPIN()) {
                    BankAccount[] temp = new BankAccount[accounts.length];
                    for (int j = 0; j < numAccounts; j++) {
                        if (accounts[j].getUserName().equals(userName)) {
                        continue;
                      }
                      temp[j] = accounts[j];
                    }
                    accounts = temp;
                 }
              }
          }
         numAccounts--;
    }


    public static boolean accountExists(String userName) {
        for (int i = 0; i < numAccounts; i++){
            if (accounts[i] != null ) {
                if (accounts[i].getUserName().equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void grow(){
        BankAccount[] temp = new BankAccount[accounts.length * 2];
        System.arraycopy(accounts, 0, temp, 0, numAccounts);
        accounts = temp;
    }

}
