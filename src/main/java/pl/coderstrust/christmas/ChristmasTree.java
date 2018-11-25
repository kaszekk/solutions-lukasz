package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {
    public static void main(String[] args) {
        System.out.println(getChristmasTree(5));
        printChristmasTree(5);
    }

    public static List<String> getChristmasTree(int heightOfTree) {
        if (heightOfTree < 0) {
            throw new IllegalArgumentException("Height of tree cannot be negative");
        }
        List<String> christmasTree = new ArrayList<>();
        StringBuilder christmasTreeItem = new StringBuilder();
        for (int i = 0; i < heightOfTree; i++) {
            christmasTreeItem.append(getSpaces(heightOfTree - i));
            christmasTreeItem.append(getAsterisks(2 * i + 1));
            christmasTree.add(christmasTreeItem.toString());
            christmasTreeItem.delete(0, christmasTreeItem.length());
        }
        christmasTreeItem.append(getSpaces(heightOfTree - 1));
        christmasTreeItem.append(getAsterisks(2));
        christmasTree.add(christmasTreeItem.toString());
        return christmasTree;
    }

    private static String getAsterisks(int numberOfAsterisks) {
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < numberOfAsterisks; i++) {
            asterisks.append("*");
        }
        return asterisks.toString();
    }

    private static String getSpaces(int numberOfSpaces) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < numberOfSpaces; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    private static void printChristmasTree(int numberOfRows) {
        List<String> christmasOutput = getChristmasTree(numberOfRows);
        for (String element : christmasOutput) {
            System.out.println(element);
        }
    }
}
