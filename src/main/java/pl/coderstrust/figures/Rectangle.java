package pl.coderstrust.figures;

public class Rectangle implements Figure {

    private double height;
    private double width;

    Rectangle(double height, double width) {
        validateHeight(height);
        validateWidth(width);
    }

    void setHeight(double height) {
        validateHeight(height);
    }

    void setWidth(double width) {
        validateWidth(width);
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of rectangle must be greater than zero");
        }
        this.height = height;
    }

    private void validateWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width of rectangle must be greater than zero");
        }
        this.width = width;
    }
}
