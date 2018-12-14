package pl.coderstrust.search;

public class LinearSearch implements SearchingMethod {
    @Override
    public int search(int[] sortedArray, int element) {
        if (sortedArray == null) {
            return -1;
        }
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
