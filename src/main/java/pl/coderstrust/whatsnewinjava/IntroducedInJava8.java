package pl.coderstrust.whatsnewinjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IntroducedInJava8 {
    public static void main(String[] args) {
        showStreamExample();
    }

    static void showStreamExample() {
        List<String> ourJavaTasks = new ArrayList<>();
        ourJavaTasks.add("FooBar");
        ourJavaTasks.add("ChristmasTree");
        ourJavaTasks.add("PascalTriangle");
        ourJavaTasks.add("HanoiTowers");
        ourJavaTasks.add("MultiThreadingMagazine");
        ourJavaTasks.add("Figures");
        ourJavaTasks.add("BinarySearch");
        ourJavaTasks.add("Regex");
        ourJavaTasks.add("DoYouLoveStreams");
        ourJavaTasks.stream().sorted()
                .map(String::toLowerCase)
                .forEach(System.out::println);
        Optional<String> reduced = ourJavaTasks.stream()
                .map(String::toUpperCase)
                .reduce((s1, s2) -> s1 + "\t" + s2);
        reduced.ifPresent(System.out::println);
    }
}
