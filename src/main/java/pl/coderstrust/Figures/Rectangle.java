package pl.coderstrust.Figures;

public class Rectangle implements Figure {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length of both rectangle sides must be greater than zero");
        }
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}
