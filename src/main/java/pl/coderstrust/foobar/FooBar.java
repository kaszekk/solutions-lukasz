package pl.coderstrust.foobar;

import java.util.ArrayList;

public class FooBar {
    public static ArrayList<String> foobar() {
        ArrayList<String> foobarResult = new ArrayList<>();
        foobarResult.add("0\n");
        for (int i = 1; i <= 100; i++) {
            foobarResult.add(i + "\t");
            if (i % 3 == 0) {
                foobarResult.add("Foo");
            }
            if (i % 5 == 0) {
                foobarResult.add("Bar");
            }
            foobarResult.add("\n");
        }
        return foobarResult;
    }
}
