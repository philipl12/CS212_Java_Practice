import java.util.Random;
import java.util.Arrays;

class ArrayTools {
    private static Random rando = new Random(System.currentTimeMillis());

    public static void populateRandom(int[] arr, int min, int max) {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = rando.nextInt(max) + min;
      }
    }

    public static boolean isSorted(int[] arr) {
      for (int i = 1; i < arr.length; ++i) {
        if (arr[i] < arr[i - 1]) {
          return false;
        }
      }
      return true;
    }

    public static int[][] slice(int[] arr, int numSlices) {
      int copy = numSlices + 1;
      int cLength = arr.length / (numSlices + 1);
      //oColumn is used to keep track of which column on the original
      //array that the for loop last copied
      int oColumn = 0;
      int[][] arr2 = new int[copy][cLength];
      for (int row = 0; row < copy; row++) {
        for (int col = 0; col < cLength; col++) {
          System.arraycopy(arr, oColumn, arr2, col, cLength);
        }
        oColumn++;
      }
      return arr2;
    }

    public static int[] concatenate(int[] arr1, int[] arr2) {
      int[] copyCat = new int[arr1.length + arr2.length];
      System.arraycopy(arr1, 0, copyCat, 0, arr1.length);
      System.arraycopy(arr2, 0, copyCat, arr1.length, arr2.length);
      return copyCat;
    }


    public static int linearSearch(int[] arr, int key) {
      int found = -1;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == key) {
          found = arr[i];
          break;
        }
      }
      return found;
    }


    public static int binarySearch(int[] arr, int low, int high, int key) {
      if (low >= 1) {
        int mid = low + (high - 1 - low) / 2;
        if (arr[mid] == key) {
          return mid;
        }
        if (arr[mid] < key) {
          return binarySearch(arr, mid + 1, high, key);
        }
        return binarySearch(arr, low, mid - 1, key);
      }
      return -1;
    }

    public static String stringify(int[] arr) {
      String strCopy = "";
      for (int i = 0; i < arr.length; i++) {
        strCopy += arr[i];
      }
      return strCopy;
    }

    public static void insertionSort(int[] arr, int low, int high) {
      int temp = 0;
      for (int i = 1; i < arr.length; i++) {
        while (arr[i] < arr[i - 1]) {
          temp = arr[i];
          arr[i] = arr[i - 1];
          arr[i - 1] = temp;
          i--;
        }
      }
    }
}
