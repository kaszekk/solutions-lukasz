package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {21, 12, 4, 6, 8, 3, 2, 1};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int[] resultArray = array.clone();
     /*   for (int i = 0; i < array.length; i++) {
            resultArray[i] = array[i];
        }*/
        boolean wasSwapped = true;
        while (wasSwapped) {
            wasSwapped = false;
            for (int i = 0; i < resultArray.length - 1; i++) {
                if (resultArray[i + 1] < resultArray[i]) {
                    int temp = resultArray[i];
                    resultArray[i] = resultArray[i + 1];
                    resultArray[i + 1] = temp;
                    wasSwapped = true;
                }
            }
        }
        return resultArray;
    }
}
