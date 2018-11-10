package pl.coderstrust.multiplication;

import java.util.ArrayList;

public class MultiplicationTable {
    public static void main(String[] args) {
        printMultiplicationTable(12);
    }

    static ArrayList<String> printMultiplicationTable(int size) {
        ArrayList<String> output = new ArrayList<>();
        output.add(String.format("%4s", " "));
        for (int i = 1; i <= size; i++) {
            output.add(String.format("%4d", i));
        }
        System.out.println();
        for (int row = 1; row <= size; row++) {
            output.add(String.format("%4d", row));
            for (int col = 1; col <= size; col++) {
                output.add(String.format("%4d", row * col));
            }
            output.add("\n");
        }
        return output;
    }
}
