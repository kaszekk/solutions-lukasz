package pl.coderstrust.multiplication;

public class MultiplicationTable {
    public static void main(String[] args) {
        int size = 12;
        printMultiplicationTable(getFormattedStringOutput(getMultiplicationTableValues(size)));
    }

    static int[][] getMultiplicationTableValues(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Argument cannot be negative");
        }
        int[][] multiplicationTable = new int[size + 1][size + 1];
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                multiplicationTable[row][col] = row * col;
            }
        }
        return multiplicationTable;
    }

    static String[] getFormattedStringOutput(int[][] table) {
        String[] formattedTableRow = new String[table.length];
        StringBuilder beingBuiltTableRow = new StringBuilder();
        addTopAndLeftBorders(table);
        beingBuiltTableRow.append((String.format("%4s", " ")));
        for (int col = 1; col < formattedTableRow.length; col++) {
            beingBuiltTableRow.append(String.format("%4s", +table[0][col]));
        }
        formattedTableRow[0] = beingBuiltTableRow.toString();
        for (int row = 1; row < table.length; row++) {
            {
                beingBuiltTableRow.delete(0, beingBuiltTableRow.length());
                for (int col = 0; col < table.length; col++) {
                    beingBuiltTableRow.append(String.format("%4s", +table[row][col]));
                }
                formattedTableRow[row] = beingBuiltTableRow.toString();
            }
        }
        return formattedTableRow;
    }

    static void printMultiplicationTable(String[] table) {
        for (String element : table) {
            System.out.println(element);
        }
    }

    private static void addTopAndLeftBorders(int[][] table) {
        for (int col = 0; col < table.length; col++) {
            table[0][col] = col;
            table[col][0] = col;
        }
    }
}
