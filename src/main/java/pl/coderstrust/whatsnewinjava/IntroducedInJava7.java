package pl.coderstrust.whatsnewinjava;

import java.io.*;

class IntroducedInJava7 {
    long underscoreInNumericLiterals = 1_234_567_890_123_456L;
    private static final String JAVA7 = "\nJava 7 new features: Strings in switch statement, try with resources, multiple exception handling, underscore in literals...";
    private static final String JAVA8 = "\nJava 8 new features: forEach() method in Iterable interface, default and static methods in interfaces, functional interfaces, lambda expressions";
    private static final String JAVA9 = "\nJava 9";

    public static void main(String[] args) {
        testStringInSwitch(JAVA7);
        copyFileUsingTryWithResources();
    }

    private static void testStringInSwitch(String parameter) {
        switch (parameter) {
            case JAVA7:
                System.out.println(JAVA7);
                break;
            case JAVA8:
                System.out.println(JAVA8);
                break;
            case JAVA9:
                System.out.println(JAVA9);
                break;
            default:
                System.out.println("no way to get here");
                break;
        }
    }

    private static void copyFileUsingTryWithResources() {
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
        System.out.println("\n copying successful.");
    }
}
