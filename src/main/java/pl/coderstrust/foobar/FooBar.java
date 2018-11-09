package pl.coderstrust.foobar;

public class FooBar {

    public static String foobar() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0\n");
        for (int i = 1; i <= 18; i++) {
            stringBuilder.append(i + "\t");
            if (i % 3 == 0) {
                stringBuilder.append("Foo");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Bar");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
