package pl.coderstrust.foobar;

import java.util.ArrayList;

public class FooBar {

    public static ArrayList<String> foobar() {
        ArrayList<String> foobarOutput = new ArrayList<>();

        foobarOutput.add("0\n");
        for (int i = 1; i <= 100; i++) {
            foobarOutput.add(i + "\t");
            if (i % 3 == 0) {
                foobarOutput.add("Foo");
            }
            if (i % 5 == 0) {
                foobarOutput.add("Bar");
            }
            foobarOutput.add("\n");
        }
        return foobarOutput;
    }
}
