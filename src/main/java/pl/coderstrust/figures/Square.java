package pl.coderstrust.figures;

public class Square implements Figure {
    private double sideLength;

    public Square(double sideLength) {
        validateSideLength(sideLength);
    }

    public void setSideLength(double sideLength) {
        validateSideLength(sideLength);
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    private void validateSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("The sideLength of a square must be greater than zero");
        } else {
            this.sideLength = sideLength;
        }
    }
}
