package pl.coderstrust.sort;

public class BubbleSort {
    public static int[] sort(int[] array) {
        int[] copyOfArrayOfInt = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyOfArrayOfInt[i] = array[i];
        }
        boolean wasSwapped = true;
        while (wasSwapped) {
            wasSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (copyOfArrayOfInt[i + 1] < copyOfArrayOfInt[i]) {
                    int temp = copyOfArrayOfInt[i];
                    copyOfArrayOfInt[i] = copyOfArrayOfInt[i + 1];
                    copyOfArrayOfInt[i + 1] = temp;
                    wasSwapped = true;
                }
            }
        }
        return copyOfArrayOfInt;
    }
}
