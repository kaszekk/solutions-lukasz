package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {-7, 6, 7, 2, 3, 1, 0, 5, 12, -4, 9, 8};
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(sort(array)));
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public static int[] sort(int[] array) {

        int[] copyOfArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyOfArray[i] = array[i];
        }
        for (int j = 0; j < array.length; j++) {
            int minimumElementIndex = j;
            for (int i = j; i < array.length - 1; i++) {
                if (copyOfArray[i + 1] < copyOfArray[minimumElementIndex]) {
                    minimumElementIndex = i + 1;
                }
            }
            int temp = copyOfArray[minimumElementIndex];
            copyOfArray[minimumElementIndex] = copyOfArray[j];
            copyOfArray[j] = temp;
        }
        return copyOfArray;
    }
}
