public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private int balance;
    private String userName;
    private int pin;

    public BankAccount(String firstName, String lastName, String userName,
                       String address, int balance, int pin) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setAddress(address);
        this.balance = balance;
        setPIN(pin);
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

}
