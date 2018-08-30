import java.util.*;

public class ThreeOrFive {
    public static void main(String[] args) {
        int n = 0, sum = 0;
        for ( ; n < 1000; n++) {
            if (n % 3 == 0 || n % 5 == 0) {
                sum += n;
                System.out.println(n);
            }
        }
        System.out.println(sum);
    }
}
