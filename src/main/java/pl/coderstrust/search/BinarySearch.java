package pl.coderstrust.search;

public class BinarySearch implements SearchingMethod {
    @Override
    public int search(int[] array, int element) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Passed array cannot be empty");
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == element) {
                return mid;
            }
            if (array[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public String getSortingMethodName() {
        return getClass().getSimpleName();
    }
}
