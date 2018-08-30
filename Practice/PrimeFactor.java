import java.util.*;
import java.util.ArrayList;
import java.math.BigInteger;

public class PrimeFactor {
    public static boolean pf(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //BigInteger factor = new BigInteger("600851475143");
        int factor = 13195;
        int largest = 0;
        ArrayList<Integer> prime = new ArrayList<>();
        prime.add(2);
        for (int i = 3; i < 100; i++) {
            if (pf(i)) prime.add(i);
        }
        for (int i = 0; factor != 1 && i < prime.size(); i++) {
            while (factor % prime.get(i) == 0 && factor != 1) {
                factor = factor / prime.get(i);
            }
            largest = prime.get(i);
        }
        System.out.println("Largest prime number that divides 600,851,475,143 is " + largest);
    }
}
