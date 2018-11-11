package pl.coderstrust.foobar;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooBarTest {
    @Test
    public void shouldReturnFoobarOutputStringToArrayList() {
        int size = 6;
        // Given

        List<String> expected = new ArrayList<>();
        expected = (Arrays.asList("0FooBar\n", "1\n", "2\n", "3Foo\n", "4\n", "5Bar\n", "6Foo\n"));

        // When
        List<String> input = FooBar.storeResult(size);


        // Then
        Assert.assertEquals(expected, input);
    }
}
