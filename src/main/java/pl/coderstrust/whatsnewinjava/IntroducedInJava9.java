package pl.coderstrust.whatsnewinjava;

interface PrivateMethodsInInterfaces {
    default void defaultInterfaceMethod() {
        privateMethod();
        privateStaticMethod();
    }

    private void privateMethod() {
        System.out.println("Private methods are handy when we have several default methods implemented in an interface...");
    }

    private static void privateStaticMethod() {
        System.out.println("... to avoid code duplication in default methods, we can extract some repeated code to private methods,\n" +
                " so that it can be reused  when needed,improving code readability at the same time.");
    }
}

public class IntroducedInJava9 implements PrivateMethodsInInterfaces {
    public static void main(String[] args) {
        printInfo();
    }

    static void printInfo() {
        IntroducedInJava9 introducedInJava9 = new IntroducedInJava9();
        introducedInJava9.defaultInterfaceMethod();
    }
}
