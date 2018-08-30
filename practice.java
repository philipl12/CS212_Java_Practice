import java.util.*;
import java.util.Arrays;

public class practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Please enter a number 1 - 100:");
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        double[] c = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
            b[i] = r.nextInt();
        }
        for (int i = 0; i < c.length; i++) {
            //line below doesn't work bc it's not creating a new c[i]
            //turn into string array
            c[i] = a[i].b[i];
        }
        in.close();
    }
}
