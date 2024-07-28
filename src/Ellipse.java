public class Ellipse extends Shape {
    private Point center;
    private double radiusX;
    private double radiusY;

    public Ellipse(Style shapeStyle, Point center, double radiusX, double radiusY) {
        super(shapeStyle);
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }


    public String toSvg() {
        String svgCode = "<svg height=\"220\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "\t<ellipse cx=\"" + center.x + "\" cy=\"" + center.y +
                "\" rx=\"" + radiusX + "\" ry=\"" + radiusY + "\"\n" +
                shapeStyle.toSvg() + "\" />\n" + "</svg>";

        return svgCode;
    }
}
