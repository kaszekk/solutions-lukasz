package pl.coderstrust.figures;

public class Rectangle implements Figure {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        validateHeight(height);
        validateWidth(width);
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        validateHeight(height);
        this.height = height;
    }

    public void setWidth(double width) {
        validateWidth(width);
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    private void validateHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of rectangle must be greater than zero");
        }
    }

    private void validateWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width of rectangle must be greater than zero");
        }
    }
}
