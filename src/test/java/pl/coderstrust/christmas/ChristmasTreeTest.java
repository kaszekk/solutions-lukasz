package pl.coderstrust.christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.AssertArrayEquals.assertArrayEquals;

class ChristmasTreeTest {
    @DisplayName("ChristmasTree Test")
    public class ChristmasTreeTest {

        @DisplayName("")
        @ParameterizedTest(name = "{index} => a={0},   b={1},   expected_a={2},     expected_b={2} ")
        @MethodSource("correctChristmasTreeArguments")
        public void shouldReturnCorrectChristmasTree(int size, List<String> expected) {
            // When
            List<String> input = ChristmasTree.getChristmasTree(size);

            // Then
            assertArrayEquals(expected, input);
        }

        private static Stream<Arguments> paramsForAreDimensionsCorrect() {
            return Stream.of(
                    Arguments.of(0, 0, 0, 0),
                    Arguments.of(4, 0, 4, 4),
                    Arguments.of(1, 1, 1, 1),
                    Arguments.of(2, 1, 2, 2),
                    Arguments.of(3, 2, 3, 3),
                    Arguments.of(3, 4, 4, 4),
                    Arguments.of(4, 4, 4, 4),
                    Arguments.of(4, 3, 4, 4),
                    Arguments.of(2, 2, 2, 2),
                    Arguments.of(3, 3, 3, 3)
            );
        }




        private Object[] correctChristmasTreeArguments() {
            return new Object[]{
                    new Object[]{0, Arrays.asList("**")},
                    new Object[]{1, Arrays.asList(
                            " *",
                            "**")},
                    new Object[]{2, Arrays.asList(
                            "  *",
                            " ***",
                            " **")},
                    new Object[]{4, Arrays.asList(
                            "    *",
                            "   ***",
                            "  *****",
                            " *******",
                            "   **")}
            };
        }

        @Test
        public void shouldThrowExceptionForNegativeSize() {
            thrown.expect(IllegalArgumentException.class);
            thrown.expectMessage("Height of tree cannot be negative");
            ChristmasTree.getChristmasTree(-1);
        }
    }
}