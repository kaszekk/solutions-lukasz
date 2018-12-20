package pl.coderstrust.hoarepartition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.coderstrust.hoarepartition.HoarePartition;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Haore partition my test")
class HoarePartitionTest {
    @DisplayName("Should return true is partition is correct for given pivot")
    @ParameterizedTest
    @MethodSource("paramsForMytest")
    void shouldCheckPivotIsInCorrectPosition(int[] array, int pivotIndex) {
        //Given
        //When
        int[] partitionedArr = HoarePartition.applyHoare(array, pivotIndex);

        boolean result = HoarePartition.testHaorePartition(partitionedArr, array[pivotIndex]);

        //Then
        assertTrue(result);

    }

    private static Stream<Arguments> paramsForMytest() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 0),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 1),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 2),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 3),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 4),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 5),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 6),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 7),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 8),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 9, 8),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 10));
    }

    // @Disabled
    @DisplayName("Should partition entry array according to given Pivot")
    @ParameterizedTest
    @MethodSource("paramsForHoare")
    void shouldReturnPartitionedArrayAccordingToGivenPivot(int[] array, int pivotIndex, int[] expected) {
        //Given
        //When
        int[] partitioned = HoarePartition.applyHoare(array, pivotIndex);

        boolean result = HoarePartition.testHaorePartition(partitioned, array[pivotIndex]);

        //Then
        // Assert.assertThat(partitioned, is(expected));
        // assertTrue(result);
    }

    private static Stream<Arguments> paramsForHoare() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 0, new int[]{1, 1, 11, 15, 3, 10, 6, 4, 2, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 1, new int[]{4, 1, 1, 2, 3, 6, 7, 10, 11, 15, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 2, new int[]{8, 7, 1, 11, 3, 10, 6, 4, 2, 1, 15}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 3, new int[]{2, 7, 8, 1, 3, 10, 6, 4, 1, 11, 15}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 4, new int[]{2, 1, 1, 3, 11, 10, 6, 4, 15, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 5, new int[]{4, 7, 8, 1, 3, 1, 6, 2, 10, 11, 15}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 6, new int[]{3, 1, 2, 4, 1, 6, 10, 11, 15, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 7, new int[]{3, 1, 2, 1, 4, 6, 10, 11, 15, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 8, new int[]{1, 1, 2, 3, 11, 10, 6, 4, 15, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 9, new int[]{1, 1, 11, 15, 3, 10, 6, 4, 2, 7, 8}),
                Arguments.of(new int[]{1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8}, 10, new int[]{6, 7, 1, 1, 3, 2, 4, 8, 10, 11, 15})

// sprawdzic rozmiar zwroconej tablicy
                //assertArrayEquals

        );
    }

}
