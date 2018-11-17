package pl.coderstrust.multiplication;

public class MultiplicationTable {
    public static void main(String[] args) {
        int size = 4;
        printMultiplicationTable(getFormattedStringOutput(getMultiplicationTableValues(size)));
    }

    static int[][] getMultiplicationTableValues(int size) {
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
        StringBuilder buildedTableRow = new StringBuilder();
        addTopAndLeftBorders(table);
        buildedTableRow.append((String.format("%4s", " ")));
        for (int col = 1; col < formattedTableRow.length; col++) {
            buildedTableRow.append(String.format("%4s", +table[0][col]));
        }
        formattedTableRow[0] = buildedTableRow.toString();
        for (int row = 1; row < table.length; row++) {
            {
                buildedTableRow.delete(0, buildedTableRow.length());
                for (int col = 0; col < table.length; col++) {
                    buildedTableRow.append(String.format("%4s", +table[row][col]));
                }
                formattedTableRow[row] = buildedTableRow.toString();
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
        int[][] topAndLeftBorderedTable = new int[table.length][table.length];
        System.arraycopy(table, 0, topAndLeftBorderedTable, 0, table.length);
        for (int col = 0; col < topAndLeftBorderedTable.length; col++) {
            topAndLeftBorderedTable[0][col] = col;
            topAndLeftBorderedTable[col][0] = col;
        }
    }
}
