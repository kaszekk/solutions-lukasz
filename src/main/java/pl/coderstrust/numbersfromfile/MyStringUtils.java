package pl.coderstrust.numbersfromfile;

class MyStringUtils {
    static void validateLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line argument cannot be null");
        }
    }
}
