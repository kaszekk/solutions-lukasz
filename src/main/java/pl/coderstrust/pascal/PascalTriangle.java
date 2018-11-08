package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        printPascalTriangle(12);
    }

    private static void printPascalTriangle(int numberOfRows) {
        for (int row = 0; row < numberOfRows; row++) {
            final int rowIndentation = (numberOfRows - row) * 2;
            System.out.format("%" + rowIndentation + "s", "");
            int value = 1;
            for (int col = 0; col <= row; col++) {
                System.out.format("%4d", value);
                value = value * (row - col) / (col + 1);
            }
            System.out.println();
        }
    }
}
