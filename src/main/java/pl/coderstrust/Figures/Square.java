package pl.coderstrust.Figures;

public class Square implements Figure {
    private double sideLength;

    public Square(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("The sideLength of square must be greater than zero");
        }
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
}
