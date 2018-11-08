package pl.coderstrust.sort;

public class SelectionSort {
    public static int[] sort(int[] intArray) {
        int[] copyOfIntArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            copyOfIntArray[i] = intArray[i];
        }
        for (int j = 0; j < intArray.length; j++) {
            int minimumElementIndex = j;
            for (int i = j; i < intArray.length - 1; i++) {
                if (copyOfIntArray[i + 1] < copyOfIntArray[minimumElementIndex]) {
                    minimumElementIndex = i + 1;
                }
            }
            int temp = copyOfIntArray[minimumElementIndex];
            copyOfIntArray[minimumElementIndex] = copyOfIntArray[j];
            copyOfIntArray[j] = temp;
        }
        return copyOfIntArray;
    }
}
