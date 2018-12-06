package pl.coderstrust.search;

public class LinearSearch {
    int search(int[] sortedArray, int lookedFor) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == lookedFor) {
                return i;
            }
        }
        return -1;
    }
}
