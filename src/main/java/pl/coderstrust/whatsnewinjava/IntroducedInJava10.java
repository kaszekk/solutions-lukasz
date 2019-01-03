package pl.coderstrust.whatsnewinjava;

class IntroducedInJava10 {
    public static void main(String[] args) {
        showLocalVariableTypeInferenceExample();
    }
    private static void showLocalVariableTypeInferenceExample() {
        var number1 = 1;
        var number2 = 2.5;
        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
    }
}
