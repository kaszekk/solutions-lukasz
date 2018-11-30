package pl.coderstrust.christmas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ChristmasTreeTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "correctChristmasTreeArguments")
    public void shouldReturnCorrectChristmasTree(int size, List<String> expected) {
        // When
        List<String> input = ChristmasTree.getChristmasTree(size);

        // Then
        assertThat(input, is(expected));
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
