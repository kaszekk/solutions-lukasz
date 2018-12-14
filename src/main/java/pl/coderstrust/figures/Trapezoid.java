package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double lowerBase;
    private double upperBase;
    private double height;

    Trapezoid(double lowerBase, double upperBase, double height) {
        validateLowerBase(lowerBase);
        validateUpperBase(upperBase);
        validateHeight(height);
    }

    void setLowerBase(double lowerBase) {
        validateLowerBase(lowerBase);
    }

    void setUpperBase(double upperBase) {
        validateUpperBase(upperBase);
    }

    void setHeight(double height) {
        validateHeight(height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * height * (lowerBase + upperBase);
    }

    private void validateLowerBase(double lowerBase) {
        if (lowerBase <= 0) {
            throw new IllegalArgumentException("Lower base of trapezoid must be greater than zero");
        }
        this.lowerBase = lowerBase;
    }

    private void validateUpperBase(double upperBase) {
        if (upperBase <= 0) {
            throw new IllegalArgumentException("Higher base of trapezoid must be greater than zero");
        }
        this.upperBase = upperBase;
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of trapezoid must be greater than zero");
        }
        this.height = height;
    }
}
