package pl.coderstrust.search;

public class BinarySearch implements SearchingMethod {
    @Override
    public int search(int[] sortedArray, int element) {
        if (sortedArray == null) {
            return -1;
        }
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == element) {
                return mid;
            }
            if (sortedArray[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
