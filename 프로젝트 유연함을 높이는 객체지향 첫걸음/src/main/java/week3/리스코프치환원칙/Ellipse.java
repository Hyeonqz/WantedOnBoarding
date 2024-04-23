package week3.리스코프치환원칙;

public class Ellipse implements Shape{
    private double majorAxis;
    private double minorAxis;

    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double calculateArea() {
        return Math.PI * majorAxis * minorAxis;
    }
}
