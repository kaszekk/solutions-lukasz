package pl.coderstrust.sort;

public class SelectionSort {
    public static int[] sort(int[] array) {
        int[] resultArray = array.clone();
        for (int j = 0; j < array.length; j++) {
            int minimumElementIndex = j;
            for (int i = j; i < array.length - 1; i++) {
                if (resultArray[i + 1] < resultArray[minimumElementIndex]) {
                    minimumElementIndex = i + 1;
                }
            }
            swapElementsInArray(resultArray, minimumElementIndex, j);
        }
        return resultArray;
    }

    private static void swapElementsInArray(int[] resultArray, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = resultArray[indexOfFirstElement];
        resultArray[indexOfFirstElement] = resultArray[indexOfSecondElement];
        resultArray[indexOfSecondElement] = temp;
    }
}
