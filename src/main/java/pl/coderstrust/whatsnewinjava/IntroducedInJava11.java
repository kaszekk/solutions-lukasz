package pl.coderstrust.whatsnewinjava;

public class IntroducedInJava11 {
    public static void main(String[] args) {
        showSomeNewStringMethods();
    }
    static void showSomeNewStringMethods() {
        var chant = "   hooray!  ";
        System.out.println("chant.isBlank() = " + chant.isBlank());
        System.out.println("chant repeat 5 times = " + chant.repeat(5));
        System.out.println("chant repeat 5 times,but stripped off white characters = " + chant.strip().repeat(5));
    }
}
