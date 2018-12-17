package pl.coderstrust.figures;

class Circle implements Figure {
    private double radius;

    Circle(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    void setRadius(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    private void validateRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius of a circle must be greater than zero");
        }
    }
}
