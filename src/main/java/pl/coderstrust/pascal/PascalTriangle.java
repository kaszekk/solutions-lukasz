package pl.coderstrust.pascal;

public class PascalTriangle {
    public static void main(String[] args) {
        printPascalTriangle(0);
    }

    static int[][] getCalculatedValues(int numberOfRows) {
        if (numberOfRows <= 0) {
            throw new IllegalArgumentException("Argument must be a positive integer");
        }
        int[][] triangleValues = new int[numberOfRows][];
        createRightSizedArraysForSubsequentRowsOfTriangle(numberOfRows, triangleValues);
        calculateAndSaveValues(numberOfRows, triangleValues);
        return triangleValues;
    }

    static String[] getFormattedOutput(int[][] values) {
        String[] formattedOutput = new String[values.length];
        
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < values.length; row++) {
            final int rowIndentation = (values.length - row) * 2;
            sb.append(String.format("%" + rowIndentation + "s", ""));
            for (int col = 0; col < values[row].length; col++) {
                sb.append(String.format("%4d", values[row][col]));
            }
            formattedOutput[row] = sb.toString();
            sb.delete(0, sb.length());
        }
        return formattedOutput;
    }

    private static void printPascalTriangle(int numberOfRows) {
        String[] formattedOutput = getFormattedOutput(getCalculatedValues(numberOfRows));
        for (String element : formattedOutput) {
            System.out.println(element);
        }
    }

    private static void createRightSizedArraysForSubsequentRowsOfTriangle(int numberOfRows, int[][] triangleValues) {
        for (int i = 0; i < numberOfRows; i++) {
            triangleValues[i] = new int[i + 1];
        }
    }

    private static void calculateAndSaveValues(int numberOfRows, int[][] triangleValues) {
        for (int row = 0; row < numberOfRows; row++) {
            int value = 1;
            for (int col = 0; col <= triangleValues[row].length - 1; col++) {
                triangleValues[row][col] = value;
                value = value * (row - col) / (col + 1);
            }
        }
    }
}
