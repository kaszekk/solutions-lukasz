package pl.coderstrust.whatsnewinjava;

import java.io.*;

public class IntroducedInJava7 {
    long underscoreInNumericLiterals = 1_234_567_890_123_456L;

    private final static String java7 = "\nJava 7 new features: Strings in switch statement, try with resources, multiple exception handling, underscore in literals...";
    private final static String java8 = "\nJava 8 new features: forEach() method in Iterable interface, default and static methods in interfaces, functional interfaces, lambda expressions";
    private final static String java9 = "\nJava 9";

    public static void main(String[] args) {
        testStringInSwitch(java7);
        copyFileUsingTryWithResources();
    }

    static void testStringInSwitch(String parameter) {
        switch (parameter) {
            case java7:
                System.out.println(java7);
                break;
            case java8:
                System.out.println(java8);
                break;
            case java9:
                System.out.println(java9);
                break;
            default:
                System.out.println("no way to get here");
        }
    }

    //------------------------------------------------------------
// Copy from one file to another file line by line.
// Java 7 has a try-with-resources statement, which ensures that
//   each resource opened in try(resources) is closed at the end of the statement.
    static void copyFileUsingTryWithResources() {
        final String sourceFile = "src/main/resources/Input.txt";
        final String targetFile = "src/main/resources/InputCopy.txt";
        System.out.println("...now copying file " + sourceFile + " to " + targetFile);
        try (BufferedReader source = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter destination = new BufferedWriter(new FileWriter(targetFile))) {
            String line;
            while ((line = source.readLine()) != null) {
                System.out.println(line);
                destination.write(line);
                destination.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // source and destination get automatically closed.
        // No need for finally to explicitly close the resources.
        System.out.println("\n copying successful.");
    }
}
