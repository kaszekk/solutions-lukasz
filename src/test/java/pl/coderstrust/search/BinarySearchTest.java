package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    int size = 2_000_000_02;
    int[] sortedArray = new int[size];

    @Test
        // @DisplayName("Test should show search")
    void should() {

        //Given

        BinarySearch binarySearch = new BinarySearch();
        int searchedValue = size - 2;
        int expected = searchedValue;
        long startTime = System.currentTimeMillis();

       //When

        int actual = binarySearch.search(sortedArray, searchedValue);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Binary search implementation took " + elapsedTime + " ms to find " + searchedValue + " element in a array");

        //Then

        assertEquals(expected, actual);


    }


    @BeforeEach
    public void createSortedArrayForTest() {

        for (int i = 0; i < sortedArray.length - 1; i++) {
            sortedArray[i] = i;
        }
    }

}