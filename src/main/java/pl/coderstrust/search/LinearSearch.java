package pl.coderstrust.search;

public class LinearSearch implements SearchingMethod {
    @Override
    public int search(int[] sortedArray, int lookedFor) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == lookedFor) {
                return i;
            }
        }
        return -1;
    }
}
