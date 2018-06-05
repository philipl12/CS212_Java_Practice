import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class BankAccount2 {
    private String firstName;
    private String lastName;
    private String address;
    private int balance;
    private String userName;
    private int pin;

    public BankAccount2(String firstName, String lastName, String userName,
                       String address, int balance, int pin) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setAddress(address);
        this.balance = balance;
        setPIN(pin);
    }

    public BankAccount2(Scanner newInfo) {
        newInfo.useDelimiter("\\S*|\\S*");
        setFirstName(newInfo.next());
        setLastName(newInfo.next());
        setAddress(newInfo.next());
        setUserName(newInfo.next());
        setPIN(newInfo.nextInt());
        this.balance = newInfo.nextInt();

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }

    public int getPIN(){
        return pin;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPIN(int pin){
        this.pin = pin;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public void subtractBalance(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Warning: withdrawal amount exceeds balance.");
        }

    }

    static boolean isValidName(String name) {
        if (name == null) return false;
        char[] c = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(c[i]) && c[i] != '-' && c[i] != ' ') {
                return false;
            }
        }
        return true;
    }

    static boolean isValidUserName(String userName) {
        if (userName == null) return false;
        char[] c = userName.toCharArray();
        for (int i = 0; i < userName.length(); i++) {
            if (!Character.isLetter(c[i]) && !Character.isDigit(c[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidPIN(int pin) {

        if (pin < 1000 || pin > 9999) {
            return false;
        }
        return true;
    }

    static void writeToFile(PrintWriter textName, String fn, String ln,
                            String address, String un, int getPin,
                            int balance) {
        try {
            File f = new File(textName.toString());
            PrintWriter pw = new PrintWriter(f);
            pw.println();
            pw.print(fn + "|" + ln + "|" + address + "|" + un + "|" +
                     getPin + "|" + balance + "\n");
            pw.close();

        }
        catch (Exception e) {
            System.out.println("No file created in bankaccount2\n");
        }


    }//end writeToFile


}
