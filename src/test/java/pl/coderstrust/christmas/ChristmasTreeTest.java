package pl.coderstrust.christmas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ChristmasTreeTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "paramsForChristmasTreeFormat")
    public void shouldReturnCorrectChristmasTreeFormattedOutputInList(int size, Object expected) {
        // When
        List<String> input = ChristmasTree.getChristmasTree(size);
        // Then
        assertThat(input, is(expected));
    }

    private Object[] paramsForChristmasTreeFormat() {
        return new Object[]{
                new Object[]{0, new ArrayList<>(Arrays.asList("**"))},
                new Object[]{1, new ArrayList<>(Arrays.asList(
                        " *",
                        "**"))},
                new Object[]{2, new ArrayList<>(Arrays.asList(
                        "  *",
                        " ***",
                        " **"))},
                new Object[]{4, new ArrayList<>(Arrays.asList(
                        "    *",
                        "   ***",
                        "  *****",
                        " *******",
                        "   **"))}
        };
    }

    @Test
    public void shouldThrowExceptionForNegativeSize() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Height of tree cannot be negative");
        ChristmasTree.getChristmasTree(-1);
    }
}
