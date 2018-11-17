package pl.coderstrust.isThatFibonacci;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FibonacciCheckerTest {

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

}