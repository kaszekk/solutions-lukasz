package pl.coderstrust.foobar;

import java.util.ArrayList;

class FooBarTestExpected {
    ArrayList<String> generate() {
        ArrayList<String> resultTestPattern = new ArrayList<>();
        resultTestPattern.add("0\n");
        for (int i = 1; i <= 100; i++) {
            resultTestPattern.add(i + "\t");
            if (i % 3 == 0) {
                resultTestPattern.add("Foo");
            }
            if (i % 5 == 0) {
                resultTestPattern.add("Bar");
            }
            resultTestPattern.add("\n");
        }
        return resultTestPattern;
    }
}
