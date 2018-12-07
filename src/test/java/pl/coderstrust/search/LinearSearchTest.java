package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearSearchTest {
    int size = 200_000_002;
    int[] sortedArray = new int[size];

    @BeforeEach
    public void createSortedArrayForTest() {

        for (int i = 0; i < sortedArray.length - 1; i++) {
            sortedArray[i] = i;
        }
    }

    @Test
        // @DisplayName("Test should show search")
    void should() {

        //Given

        LinearSearch linearSearch = new LinearSearch();
        int searchedValue = size - 2;
        int expected = searchedValue;
        long startTime = System.currentTimeMillis();

        //When

        int actual = linearSearch.search(sortedArray, searchedValue);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Linear search implementation took " + elapsedTime + " ms to find " + searchedValue + " element in a array");


        //Then

        assertEquals(expected, actual);

    }
}