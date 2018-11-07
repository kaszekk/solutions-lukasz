package pl.coderstrust.multiplication;

public class MultiplicationTable {
    public static void main(String[] args) {
        printMultiplicationTable(12);
    }

    private static void printMultiplicationTable(int size) {
        System.out.printf("%4s", " ");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        for (int row = 1; row <= size; row++) {
            System.out.printf("%4d", row);
            for (int col = 1; col <= size; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }
    }
}
