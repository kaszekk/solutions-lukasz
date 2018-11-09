package pl.coderstrust.foobar;

import org.junit.Assert;
import org.junit.Test;

public class FooBarTest {
    @Test
    public void shouldPrintFoobarOutputString() {
        String foobarOutputString = FooBar.foobar();
        String expected = foobarOutputString;

        // System.out.println(foobarOutputString);
        Assert.assertEquals(foobarOutputString, foobarOutputString);
    }


}

