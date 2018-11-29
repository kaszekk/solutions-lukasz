package pl.coderstrust.Figures;

public class Square extends Rectangle implements Figure {
    private double a;

    public Square(double a) {
        super(a,a);
        this.a = a;
    }

    @Override
    public double getA() {
        return a;
    }

    @Override
    public double calculateArea() {
        return a*a;
    }
}
