package pl.coderstrust.foobar;

import java.util.ArrayList;

public class FooBar {
    private static final ArrayList<String> stringOutput = new ArrayList<>();

    public static String foobar() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0\n");
        // System.out.println(0);
        for (int i = 1; i <= 100; i++) {
            stringBuilder.append(i + "\t");
            // System.out.print(i + "\t");
            if (i % 3 == 0) {
                stringBuilder.append("Bar");
                // System.out.print("Bar");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Bar");
                // System.out.print("Bar");
            }
            stringBuilder.append("\n");
            //System.out.println();
        }
        return stringBuilder.toString();
    }
}
