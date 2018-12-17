package pl.coderstrust.figures;

class Rectangle implements Figure {

    private double height;
    private double width;

    Rectangle(double height, double width) {
        validateHeight(height);
        validateWidth(width);
        this.height = height;
        this.width = width;
    }

    void setHeight(double height) {
        validateHeight(height);
        this.height = height;
    }

    void setWidth(double width) {
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
