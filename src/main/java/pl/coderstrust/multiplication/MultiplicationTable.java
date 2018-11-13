package pl.coderstrust.multiplication;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.print(getResult(0));
    }

    static List<String> getResult(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("Multiplication table size cannot be negative");
        }
        List<String> result = new ArrayList<>();
        StringBuilder item = new StringBuilder();
        // item.append(String.format("%4s", " "));
        for (int i = 1; i <= size; i++) {
            item.append(i);
        }
        // item.append("\n");
        result.add(item.toString());
        item.delete(0, item.length());
        for (int row = 1; row <= size; row++) {
            item.append(row);
            for (int col = 1; col <= size; col++) {
                item.append(row * col);
            }
            // item.append("\n");
            result.add(item.toString());
            item.delete(0, item.length());
        }
        return result;
    }
}
