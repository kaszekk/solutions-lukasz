package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

public class FooBar {
    public static List<String> getResult(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number of lines must be greater or equal to zero");
        }
        StringBuilder item = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            item.append(String.format("%d", i));
            if (i % 3 == 0) {
                item.append("Foo");
            }
            if (i % 5 == 0) {
                item.append("Bar");
            }
            item.append("\n");
            result.add(item.toString());
            item.delete(0, item.length());
        }
        return result;
    }
}
