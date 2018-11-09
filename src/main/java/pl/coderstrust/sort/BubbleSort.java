package pl.coderstrust.sort;

public class BubbleSort {
    public static int[] sort(int[] array) {
        int[] resultArray = array.clone();
        for (int j = 0; j < resultArray.length - 1; j++) {
            for (int i = 0; i < resultArray.length - 1 - j; i++) {
                if (resultArray[i + 1] < resultArray[i]) {
                    swapElementsInArray(resultArray, i + 1, i);
                }
            }
        }
        return resultArray;
    }

    private static void swapElementsInArray(int[] resultArray, int indexOfFirstElement, int indexOfSecondElement) {
        int temp = resultArray[indexOfFirstElement];
        resultArray[indexOfFirstElement] = resultArray[indexOfSecondElement];
        resultArray[indexOfSecondElement] = temp;
    }
}
