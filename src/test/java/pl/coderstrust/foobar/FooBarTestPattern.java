package pl.coderstrust.foobar;

import java.util.ArrayList;

final class FooBarTestPattern {

      ArrayList<String> generateTestPattern() {
        ArrayList<String> outputTestPattern = new ArrayList<>();

        outputTestPattern.add("0\n");
        for (int i = 1; i <= 10; i++) {
            outputTestPattern.add(i + "\t");
            if (i % 3 == 0) {
                outputTestPattern.add("Foo");
            }
            if (i % 5 == 0) {
                outputTestPattern.add("Bar");
            }
            outputTestPattern.add("\n");
        }
        return outputTestPattern;
    }
}
