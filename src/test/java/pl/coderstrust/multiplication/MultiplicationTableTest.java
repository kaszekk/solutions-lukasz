package pl.coderstrust.multiplication;

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
public class MultiplicationTableTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "getExpectedParameters")
    public void shouldReturnCorrectMultiplicationTableList(int size, Object expected) {
        // When
        List<String> input = MultiplicationTable.getResult(size);
        // Then
        assertThat(input, is(expected));
    }

    private Object[] getExpectedParameters() {
        return new Object[]{
                new Object[]{0, new ArrayList<>(Arrays.asList("    "))},
                new Object[]{1, new ArrayList<>(Arrays.asList(
                        "       1",
                        "   1   1"))},

                new Object[]{2, new ArrayList<>(Arrays.asList(
                        "       1   2",
                        "   1   1   2",
                        "   2   2   4"))},

                new Object[]{4, new ArrayList<>(Arrays.asList(
                        "       1   2   3   4",
                        "   1   1   2   3   4",
                        "   2   2   4   6   8",
                        "   3   3   6   9  12",
                        "   4   4   8  12  16"))}
        };
    }

    @Test
    public void shouldThrowExceptionForInvalidArgument() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Size argument cannot be negative");
        MultiplicationTable.getResult(-1);
    }
}
