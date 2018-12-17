package pl.coderstrust.figures;

class Trapezoid implements Figure {
    private double lowerBase;
    private double upperBase;
    private double height;

    Trapezoid(double lowerBase, double upperBase, double height) {
        validateLowerBase(lowerBase);
        this.lowerBase = lowerBase;
        validateUpperBase(upperBase);
        this.upperBase = upperBase;
        validateHeight(height);
        this.height = height;
    }

    void setLowerBase(double lowerBase) {
        validateLowerBase(lowerBase);
        this.lowerBase = lowerBase;
    }

    void setUpperBase(double upperBase) {
        validateUpperBase(upperBase);
        this.upperBase = upperBase;
    }

    void setHeight(double height) {
        validateHeight(height);
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * height * (lowerBase + upperBase);
    }

    private void validateLowerBase(double lowerBase) {
        if (lowerBase <= 0) {
            throw new IllegalArgumentException("Lower base of trapezoid must be greater than zero");
        }
    }

    private void validateUpperBase(double upperBase) {
        if (upperBase <= 0) {
            throw new IllegalArgumentException("Higher base of trapezoid must be greater than zero");
        }
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of trapezoid must be greater than zero");
        }
    }
}
