package pl.coderstrust.search;

public class BinarySearch implements SearchingMethod {
    public static void main(String[] args) {
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(sortedArray, 4));
    }

    @Override
    public int search(int[] sortedArray, int searched) {
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == searched) {
                return mid;
            }
            if (sortedArray[mid] > searched) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
