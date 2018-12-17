package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DoYouLoveStreams {

    public static void main(String[] args) throws IOException {
        String REGEX = "([0-9]*\\)*\\(*\\s*)+";
        List<String> lines = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\Input.txt"));
        stream
                .filter(v -> v.matches(REGEX))
                // .forEach(strNumber -> Integer.valueOf(strNumber))
                .map(line -> line.split("\\s+") // line -> stream of Strings
                );
        //  .forEach(strArr -> Arrays.stream(strArr));
        //     .map(el -> Integer.valueOf(el))
        // .peek(System.out::println)
        //  .forEach(el -> System.out.println(el.getClass()));
        //.reduce("", (s1, s2) -> s1 + s2);


    }

//=========================================

       /*     .filter()
            . map()
            .forEach(arrayOfNumbers -> {
            String number = Arrays.stream(arrayOfNumbers);

            long numbers = Arrays.stream(arrayOfNumbers);

            lines.add(String.format())
            });*/
//==========================================


//  .reduce(0, (value1, value2) -> value1 + value2);
//    System.out.println(result);


//================================ liczy sume wszystkich linii==============
//        String REGEX = "([0-9]*\\)*\\(*\\s*)+";
//
//        Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\Input.txt"));
//        int result = stream
//                .filter(v -> v.matches(REGEX))
//                .flatMap(line -> Arrays.stream(line.split("\\s+")))   // splituje po bialych znakach
//                .map(string -> Integer.valueOf(string))
//                .reduce(0, (value1, value2) -> value1 + value2);
//        System.out.println(result);
//=================================================================================


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









