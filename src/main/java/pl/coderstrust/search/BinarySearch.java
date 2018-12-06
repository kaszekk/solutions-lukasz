package pl.coderstrust.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(sortedArray, 18));
    }

    int search(int[] sortedArray, int lookedFor) {
        int numberOfPicks = 0;

        int prevDivIndex = sortedArray.length - 1;
        int divIndex = prevDivIndex / 2;
        numberOfPicks++;

        while (divIndex != prevDivIndex) {
            if (sortedArray[divIndex] > lookedFor) {
                prevDivIndex = divIndex;
                divIndex /= 2;
                numberOfPicks++;
            } else if (sortedArray[divIndex] < lookedFor) {
                prevDivIndex = divIndex;
                divIndex = divIndex + (sortedArray.length - divIndex) / 2;
                numberOfPicks++;
            } else if (sortedArray[divIndex] == lookedFor) {
                System.out.println("Found in " + numberOfPicks + " picks");
                return divIndex;
            }
        }
        return -1;
    }
}


/*

    int search(int[] sortedArray, int lookedFor) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == lookedFor) {
                return i;
            }
        }
        return -1;
    }*/
