package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {
    public static void main(String[] args) {
        System.out.println(getResult(5));
        printChristmasTree(5);
    }

    public static List<String> getResult(int heightOfTree) {
        if (heightOfTree < 0) {
            throw new IllegalArgumentException("Argument cannot be negative");
        }
        List<String> ChristmasTreeRow = new ArrayList<>();
        StringBuilder christmasTreeItem = new StringBuilder();
        for (int i = 0; i < heightOfTree; i++) {
            christmasTreeItem.append(includeSpaces(heightOfTree - i)).append(includeAsterisks(2 * i + 1));
            ChristmasTreeRow.add(christmasTreeItem.toString());
            christmasTreeItem.delete(0, christmasTreeItem.length());
        }
        christmasTreeItem.append(includeSpaces(heightOfTree - 1)).append(includeAsterisks(2));
        ChristmasTreeRow.add(christmasTreeItem.toString());
        return ChristmasTreeRow;
    }

    private static String includeAsterisks(int numberOfAsterisks) {
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < numberOfAsterisks; i++) {
            asterisks.append("*");
        }
        return asterisks.toString();
    }

    private static String includeSpaces(int numberOfSpaces) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < numberOfSpaces; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    private static void printChristmasTree(int numberOfRows) {
        List<String> christmasOutput = getResult(numberOfRows);
        for (String element : christmasOutput) {
            System.out.println(element);
        }
    }
}
