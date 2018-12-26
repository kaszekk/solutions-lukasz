package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double baseLength;
    private double height;

    public Triangle(double baseLength, double height) {
        validateBaseLength(baseLength);
        validateHeight(height);
        this.baseLength = baseLength;
        this.height = height;
    }

    public void setBaseLength(double baseLength) {
        validateBaseLength(baseLength);
        this.baseLength = baseLength;
    }

    public void setHeight(double height) {
        validateHeight(height);
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * baseLength * height;
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of triangle must be greater than zero");
        }
    }

    private void validateBaseLength(double baseLength) {
        if (baseLength <= 0) {
            throw new IllegalArgumentException("Base length of trapezoid must be greater than zero");
        }
    }
}
