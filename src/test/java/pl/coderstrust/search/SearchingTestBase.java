package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SearchingTestBase {
    public abstract SearchingMethod getSearchingMethod();

    private int size = 200_000_002;
    private int[] sortedArray = new int[size];

    @BeforeEach
    void createSortedArrayForTest() {

        for (int i = 0; i < sortedArray.length - 1; i++) {
            sortedArray[i] = i;
        }
    }

    @Test
    void shouldSearchForElementInSortedArray() {

        //Given

        //LinearSearch linearSearch = new LinearSearch();
        int searchedValue = size - 2;
        int expected = searchedValue;
        long startTime = System.currentTimeMillis();

        //When

        int actual = getSearchingMethod().search(sortedArray, searchedValue);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Linear search implementation took " + elapsedTime + " ms to find " + searchedValue + " element in a array");

        //Then

        assertEquals(expected, actual);
    }
}
