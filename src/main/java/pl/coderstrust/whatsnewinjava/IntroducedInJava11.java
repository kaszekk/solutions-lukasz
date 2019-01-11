package pl.coderstrust.whatsnewinjava;

class IntroducedInJava11 {
    public static void main(String[] args) {
        showSomeNewStringMethods();
    }

    private static void showSomeNewStringMethods() {
        var chant = "   hooray!  ";
        System.out.println("chant.isBlank() = " + chant.isBlank());
        System.out.println("chant repeat 5 times = " + chant.repeat(5));
        System.out.println("chant repeat 5 times,but stripped off white characters = " + chant.strip().repeat(5));
    }
}
