package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        printPascalTriangle(5);
    }

    private static int[][] calculateValues(int numberOfRows) {
        int[][] triangleValues = new int[numberOfRows][];
        createRightSizedArraysForSubsequentRowsOfTriangle(numberOfRows, triangleValues);
        for (int row = 0; row < numberOfRows; row++) {
            int value = 1;
            for (int col = 0; col <= triangleValues[row].length - 1; col++) {
                triangleValues[row][col] = value;
                value = value * (row - col) / (col + 1);
            }
        }
        return triangleValues;
    }

    private static void createRightSizedArraysForSubsequentRowsOfTriangle(int numberOfRows, int[][] triangleValues) {
        for (int i = 0; i < numberOfRows; i++) {
            triangleValues[i] = new int[i + 1];
        }
    }

    private static void printPascalTriangle(int numberOfRows) {
        int[][] triangleValues = calculateValues(numberOfRows);
        for (int row = 0; row < triangleValues.length; row++) {
            final int rowIndentation = (numberOfRows - row) * 2;
            System.out.format("%" + rowIndentation + "s", "");
            for (int col = 0; col < triangleValues[row].length; col++) {
                System.out.format("%4d", triangleValues[row][col]);
            }
            System.out.println();
        }
    }
}
