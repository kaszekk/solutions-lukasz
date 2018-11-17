package pl.coderstrust.multiplication;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.multiplication.MultiplicationTable.getMultiplicationTableValues;

@DisplayName("Should pass the method parameters provided by the multiplicationProvider() method")
class MethodSourceExampleTest {

    @DisplayName("Should calculate the correct multiplication")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, a*b={2}")
    @MethodSource("multiplicationProvider")
    void shouldCalculateMultiplication(int a, int b, int c) {

        //Given
        int size = 4;
        int expected = c;

        //When
        int[][] input = getMultiplicationTableValues(size);

        //Then
        assertThat(input[a][b], is(expected));
    }

    private static Stream<Arguments> multiplicationProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(4, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 2),
                Arguments.of(3, 2, 6),
                Arguments.of(3, 4, 12),
                Arguments.of(4, 4, 16),
                Arguments.of(4, 3, 12),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 3, 9)
        );
    }

    class ExceptionTesting {
        //  @Test
        public void shouldThrowIllegalArgumentExceptionForNegativeSize() {
            assertThrows(IllegalArgumentException.class,
                    () -> {
                        //int size = -1;
                        getMultiplicationTableValues(-1);
                        //do whatever you want to do here
                        //ex : objectName.thisMethodShoulThrowNullPointerExceptionForNullParameter(null);
                    });
        }
    }
}
