import java.util.*;
import java.util.regex.*;

public class PigLatin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a word to be translated into pig latin:");
        while (!in.hasNext("[A-Za-z]+")) {
            System.out.println("Letters only please");
            in.next();
        }
        String copy = in.next();
        char[] ch = copy.toCharArray();
        System.out.print("Your word is ");
        for (int i = 1; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
        System.out.println("-" + ch[0] + "ay");
        in.close();
    }
}
