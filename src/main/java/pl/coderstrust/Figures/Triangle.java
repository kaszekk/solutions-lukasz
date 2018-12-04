package pl.coderstrust.Figures;

public class Triangle implements Figure {
    private double baseLength;
    private double height;

    public Triangle(double baseLength, double height) {
        if (baseLength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Length of both: triangle base and height must be greater than zero");
        }
        this.height = height;
        this.baseLength = baseLength;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public double getHeigth() {
        return height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * baseLength * height;
    }
}
