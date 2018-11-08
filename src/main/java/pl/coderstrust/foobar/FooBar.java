package pl.coderstrust.foobar;

import java.util.ArrayList;

public class FooBar {
    private static final ArrayList<String> stringOutput = new ArrayList<>();

    public static void main(String[] args) {
        for (String el : foobar()) {
            System.out.print(el);
        }
    }

    private static ArrayList<String> foobar() {
        stringOutput.add("0\n");
        // System.out.println(0);
        for (int i = 1; i <= 100; i++) {
            stringOutput.add(i + "\t");
            // System.out.print(i + "\t");
            if (i % 3 == 0) {
                stringOutput.add("Foo");
                // System.out.print("Foo");
            }
            if (i % 5 == 0) {
                stringOutput.add("Bar");
                // System.out.print("Bar");
            }
            stringOutput.add("\n");
            //System.out.println();
        }
        return stringOutput;
    }
}
