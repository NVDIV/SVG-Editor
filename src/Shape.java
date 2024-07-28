public abstract class Shape {
    protected Style shapeStyle;

    public Shape(Style shapeStyle) {
        this.shapeStyle = shapeStyle;
    }

    public abstract String toSvg();
}
