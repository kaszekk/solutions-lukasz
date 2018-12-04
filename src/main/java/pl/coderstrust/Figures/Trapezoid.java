package pl.coderstrust.Figures;

public class Trapezoid implements Figure {
    private double lowerBase;
    private double upperBase;
    private double height;

    public Trapezoid(double lowerBase, double upperBase, double height) {
        if (lowerBase <= 0 || upperBase <= 0 || height <= 0) {
            throw new IllegalArgumentException("All trapezoid parameters: lowerBase, upperBase, height -  must be greater than zero");
        }
        this.lowerBase = lowerBase;
        this.upperBase = upperBase;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * height * (lowerBase + upperBase);
    }
}
