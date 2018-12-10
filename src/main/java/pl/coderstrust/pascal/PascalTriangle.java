package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<String> getPascalTriangle(int numberOfRows) {
        if (numberOfRows <= 0) {
            throw new IllegalArgumentException("Number of rows must be greater than zero");
        }
        List<String> pascalTriangleValues = new ArrayList<>();
        StringBuilder pascalTriangleRowOfValuesBuilder = new StringBuilder();
        for (int row = 0; row < numberOfRows; row++) {
            pascalTriangleRowOfValuesBuilder.delete(0, pascalTriangleRowOfValuesBuilder.length());
            int value = 1;
            pascalTriangleRowOfValuesBuilder.append(value);
            for (int col = 0; col < row; col++) {
                value = value * (row - col) / (col + 1);
                pascalTriangleRowOfValuesBuilder.append(" ");
                pascalTriangleRowOfValuesBuilder.append(value);
            }
            pascalTriangleValues.add(pascalTriangleRowOfValuesBuilder.toString());
        }
        return pascalTriangleValues;
    }
}
