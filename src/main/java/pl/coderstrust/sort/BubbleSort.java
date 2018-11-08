package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {-7, 6, 7, 2, 3, 1, 0, 5, 12, -4, 9, 8};
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Sorted array " + Arrays.toString(sort(array)));
       /* for (int element : array) {
            System.out.print(element + " ");
        }*/
    }

    public static int[] sort(int[] array) {

        int[] copyOfArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyOfArray[i] = array[i];
        }
        boolean wasSwapped = true;
        while (wasSwapped) {
            wasSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (copyOfArray[i + 1] < copyOfArray[i]) {
                    int temp = copyOfArray[i];
                    copyOfArray[i] = copyOfArray[i + 1];
                    copyOfArray[i + 1] = temp;
                    wasSwapped = true;
                }
            }
        }
        return copyOfArray;
    }
}
