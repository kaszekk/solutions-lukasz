package pl.coderstrust.sort;

public class BubbleSort {
    public static int[] sort(int[] arrayOfInt) {
        int[] copyOfArrayOfInt = new int[arrayOfInt.length];
        for (int i = 0; i < arrayOfInt.length; i++) {
            copyOfArrayOfInt[i] = arrayOfInt[i];
        }
        boolean wasSwapped = true;
        while (wasSwapped) {
            wasSwapped = false;
            for (int i = 0; i < arrayOfInt.length - 1; i++) {
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
