import java.io.*;

class Main {

    public static void main(String[] args) {
        int letters[] = new int[256];
        int myChar;

        for (int i = 0; i < 256; i++) {
            letters[i] = 0;
        }

        for (int i = 0; i < args.length; i++) {
            String inputFile = args[i];
            File f = new File(inputFile);
            try {
                BufferedReader buffed = new BufferedReader(new FileReader(f));
                while((myChar = buffed.read()) != -1) {
                    //System.out.println(myChar);
                    for (int j = 0; j < 256; j++) {
                        if (myChar == j) {
                            letters[j]++;
                            break;
                        }
                    }
                }
                for (int k = 0; k < 256; k++) {
                    if (letters[k] > 0) {
                        System.out.println((char)k + "   " + letters[k]);
                    }
                }
                buffed.close();
            } catch (Exception e) {
                System.out.println("No file");
            }
        }
    }
}
