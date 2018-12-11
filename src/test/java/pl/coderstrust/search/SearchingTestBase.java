package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SearchingTestBase {
    public abstract SearchingMethod getSearchingMethod();

    private int size = 200_000_001;
    private int[] sortedArray = new int[size];

    @BeforeEach
    void createSortedArrayForTest() {
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }
    }

    @Test
    void shouldSearchForElementInSortedArray() {
        //Given
        int searchedValue = size - 1;
        int expected = searchedValue;
        long startTime = System.currentTimeMillis();

        //When
        int actual = getSearchingMethod().search(sortedArray, searchedValue);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(getSearchingMethod().getClass().getSimpleName() + " implementation took " + elapsedTime + " ms to find element at index number " + searchedValue + " in the array");

        //Then
        assertEquals(expected, actual);
    }
}
