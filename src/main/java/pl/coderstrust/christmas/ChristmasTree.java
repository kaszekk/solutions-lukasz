package pl.coderstrust.christmas;

public class ChristmasTree {
    public static void main(String[] args) {
        printChristmasTree(8);
    }

    public static void printChristmasTree(int heightOfTree) {
        for (int i = 0; i < heightOfTree; i++) {
            printSpaces(heightOfTree - i);
            printAsterisks(2 * i + 1);
            System.out.print("\n");
        }
        printSpaces(heightOfTree - 1);
        printAsterisks(2);
    }

    private static void printAsterisks(int numberOfAsterisks) {
        for (int i = 0; i < numberOfAsterisks; i++) {
            System.out.print("*");
        }
    }

    private static void printSpaces(int numberOfSpaces) {
        for (int i = 0; i < numberOfSpaces; i++) {
            System.out.print(" ");

        }
    }
}
