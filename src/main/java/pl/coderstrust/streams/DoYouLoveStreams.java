package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DoYouLoveStreams {

    public static void main(String[] args) throws IOException {
        String REGEX = "([0-9]*\\)*\\(*\\s*)+";
        Files.lines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\solutions-9-lukasz-f\\src\\main\\resources\\Input.txt"))
                .filter(v -> v.matches(REGEX))
                .map(Integer::valueOf)
                .forEach((sum,val)-> {
                    sum + val;
                });

    }

/*
        Stream<String> stream = Arrays.stream("1 2 3 4  ".split("\\s+"));
        stream
                .map(string -> Integer.valueOf(string))
                .reduce(0, (a, b) -> a + b)
                .map(IntValue -> String.valueOf(IntValue))*/
        // System.out.println(result);


/// sumuje
       /* Stream<String> stream = Arrays.stream("1 2 3 4  ".split("\\s"));
        int result = stream
                .map(string -> Integer.valueOf(string))
                .reduce(0, (a, b) -> a + b);
        System.out.println(result);  */







       /* Stream.of("1 2 3 4 ", "5 6 7 8 ", "3434 3 43 434 ", " 3434g  33")
                .filter(v -> v.matches(REGEX))
                .mapTo
                //.map(v -> v.)
                // .map(v -> v.replace(" ", "+"))
                .mapT
                .forEach(System.out::println);*/







/*

        Stream.of("kot", "pies,", "bober", "zyrafa", "aligator", "mapa", "tama", "obama", "zadnychniema")
                */
/*  .filter(v -> v.contains("a"))
                  .filter(v -> v.contains("m"))
                  .filter(v -> v.contains("am"))*//*

                .sorted()
                //  .map(v -> v.toUpperCase())
                .map(String::toUpperCase)
                .map(String::toLowerCase)

                //   .map(v -> v.concat("tyty"))
                //  .map(v -> v.substring(1, 6))
                .forEach(v -> System.out.println(v));


        IntStream.range(0, 10)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
*/

    }







