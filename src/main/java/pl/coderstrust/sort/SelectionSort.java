package pl.coderstrust.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {-7, 6, 7, 2, 3, 1, 0, 5, 12, -4, 9, 8};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            int minIndex = j;
            for (int i = j; i < array.length - 1; i++) {
                if (array[i + 1] < array[minIndex]) {
                    minIndex = i + 1;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
