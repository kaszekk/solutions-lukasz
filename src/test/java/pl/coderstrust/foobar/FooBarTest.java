package pl.coderstrust.foobar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooBarTest {
    @Test
    public void shouldPrintFoobarOutputString() {
        // Given
        String expected = "0\n" +
                "1\t\n" +
                "2\t\n" +
                "3\tFoo\n" +
                "4\t\n" +
                "5\tBar\n" +
                "6\tFoo\n" +
                "7\t\n" +
                "8\t\n" +
                "9\tFoo\n" +
                "10\tBar\n" +
                "11\t\n" +
                "12\tFoo\n" +
                "13\t\n" +
                "14\t\n" +
                "15\tFooBar\n" +
                "16\t\n" +
                "17\t\n" +
                "18\tFoo\n";

        // When
        String input = FooBar.foobar();

        // Then
        assertEquals(expected, input);
    }
}
