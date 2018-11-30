package pl.coderstrust.Figures;

public class Triangle implements Figure {
    private double a;
    private double height;

    public double getA() {
        return a;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * a * height;
    }
}
