class HW5Tools {
    public static void partition(int[] arr, int low, int high) {
        int pivotActual = arr[high];
        int mid = arr.length / 2;
        int i = (low - 1);
        int temp;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivotActual) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;



    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if (arr.length < 2) {
            return arr;
        }
        int half = arr.length / 2;
        int[] left = new int[half];
        System.arraycopy(arr, 0 , left, 0, half);
        int[] right = new int[half];
        System.arraycopy(arr, 3 , right, 0, half);
        int[] leftSide = new int[left.length];
        int[] rightSide = new int[right.length];
        int middle = (low + high) / 2;
        leftSide = mergeSort(left, low, middle);
        rightSide = mergeSort(right, middle + 1, high);
        arr = merge(leftSide, rightSide);
        return arr;


    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int checkLength = 0;

        if (left.length >= right.length) {
            checkLength = left.length;
        }
        else {
            checkLength = right.length;
        }
        int j = 0;
        for (int i = 0; i < checkLength; i++) {
            if (left[i] > right[i]) {
                merged[j] = right[i];
                merged[j + 1] = left[i];
            }
            else if (right[i] > left[i]) {
                merged[j] = left[i];
                merged[j + 1] = right[i];

            }
            j += 2;
        }

        return merged;
    }

}
