package pl.coderstrust.foobar;

import java.util.ArrayList;

public class FooBar {
    public static ArrayList<String> foobar() {
        ArrayList<String> result = new ArrayList<>();
        result.add("0\n");
        for (int i = 1; i <= 100; i++) {
            result.add(i + "\t");
            if (i % 3 == 0) {
                result.add("Foo");
            }
            if (i % 5 == 0) {
                result.add("Bar");
            }
            result.add("\n");
        }
        return result;
    }
}
