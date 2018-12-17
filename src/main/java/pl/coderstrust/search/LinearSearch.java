package pl.coderstrust.search;

public class LinearSearch implements SearchingMethod {
    @Override
    public int search(int[] array, int element) {
        if (array == null) {
            throw new NullPointerException("Null reference to array passed");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Cannot perform search on an empty array");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String getSortingMethodName() {
        return getClass().getSimpleName();
    }
}
