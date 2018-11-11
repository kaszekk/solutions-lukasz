package pl.coderstrust.foobar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FooBarTest {
    @Test
    public void shouldReturnCorrectFooBarList() {
        int size = 6;
        // Given

        List<String> expected = (Arrays.asList("0FooBar\n", "1\n", "2\n", "3Foo\n", "4\n", "5Bar\n", "6Foo\n"));

        // When
        List<String> input = FooBar.getResult(size);

        // Then
        Assert.assertEquals(expected, input);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        int size = -1;

        // When
        boolean thrown = false;
        try {
            FooBar.getResult(size);
        } catch (IllegalArgumentException ex) {
            thrown = true;
        }

        // Then
        Assert.assertTrue(thrown);
    }
}
