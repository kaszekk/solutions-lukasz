package pl.coderstrust.Figures;

public class Rectangle implements Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        if (a == 0 || b == 0) { //<=0

        } else if (a < 0 || b < 0) {

        }
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }
}
