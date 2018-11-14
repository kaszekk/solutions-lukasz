package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {
    public static void main(String[] args) {
        System.out.println(getResult(3));
    }

    public static List getResult(int heightOfTree) {
        if (heightOfTree < 0) {
            throw new IllegalArgumentException("Argument cannot be negative");
        }
        List<String> ChristmasTreeRow = new ArrayList<>();
        StringBuilder christmasTreeItem = new StringBuilder();
        for (int i = 0; i < heightOfTree; i++) {
            christmasTreeItem.append(spaces(heightOfTree - i)).append(asterisks(2 * i + 1));
            ChristmasTreeRow.add(christmasTreeItem.toString());
            christmasTreeItem.delete(0, christmasTreeItem.length());
        }
        christmasTreeItem.append(spaces(heightOfTree - 1)).append(asterisks(2));
        ChristmasTreeRow.add(christmasTreeItem.toString());
        return ChristmasTreeRow;
    }

    private static String asterisks(int numberOfAsterisks) {
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < numberOfAsterisks; i++) {
            asterisks.append("*");
        }
        return asterisks.toString();
    }

    private static String spaces(int numberOfSpaces) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < numberOfSpaces; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
