package pl.coderstrust.Figures;

public class Rectangle implements Figure {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        setHeightIfValid(height);
        setWidthIfValid(width);
    }

    public void setHeight(double height) {
        setHeightIfValid(height);
    }

    public void setWidth(double width) {
        setWidthIfValid(width);
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    private void setHeightIfValid(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height of rectangle must be greater than zero");
        } else {
            this.height = height;
        }
    }

    private void setWidthIfValid(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width of rectangle must be greater than zero");
        } else {
            this.width = width;
        }
    }
}
