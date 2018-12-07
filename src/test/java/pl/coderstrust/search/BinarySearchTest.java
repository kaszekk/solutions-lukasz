package pl.coderstrust.search;

class BinarySearchTest extends SearchingTestBase {

    public SearchingMethod getSearchingMethod() {
        return new BinarySearch();
    }
}

    /*
    int size = 200_000_002;
    int[] sortedArray = new int[size];

    @Test
        // @DisplayName("Test should show search")
    void should() {

        //Given

        BinarySearch binarySearch = new BinarySearch();
        int searchedValue = size - 2;
        int expected = searchedValue;
        long startTime = System.nanoTime();

        //When

        int actual = binarySearch.search(sortedArray, searchedValue);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Binary search implementation took " + elapsedTime / 10e6 + " ms to find " + searchedValue + " element in a array");

        //Then

        assertEquals(expected, actual);

    }

    @BeforeEach
    public void createSortedArrayForTest() {

        for (int i = 0; i < sortedArray.length - 1; i++) {
            sortedArray[i] = i;
        }
    }
}*/