import java.util.ArrayList;

public class Polygon extends Shape {

    private ArrayList<Point> points;

    public Polygon (ArrayList<Point> points, Style polygonStyle) {
        super(polygonStyle);
        this.points = new ArrayList<>(points);
    }

    public Polygon(ArrayList<Point> points) {
        super(new Style("none", "black", 1.0));  // Domyślny styl: przezroczyste wypełnienie, czarny obrys, grubość 1 piksel
        this.points = new ArrayList<>(points);
    }

    public Polygon(Polygon other) {
        super(new Style(other.shapeStyle.fillColor, other.shapeStyle.strokeColor, other.shapeStyle.strokeWidth));
        this.points = new ArrayList<>();
        for (Point p : other.points) {
            this.points.add(new Point(p.x, p.y));
        }
    }

    public static Polygon square(Segment diagonal, Style polygonStyle) {
        Point p1 = diagonal.getStartPoint();
        Point p2 = diagonal.getEndPoint();

        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();

        Point midPoint = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);

        double halfDiagonal = Math.sqrt(dx * dx + dy * dy) / 2;

        double angle = Math.atan2(dy, dx);

        Point p3 = new Point(midPoint.getX() - halfDiagonal * Math.sin(angle), midPoint.getY() + halfDiagonal * Math.cos(angle));
        Point p4 = new Point(midPoint.getX() + halfDiagonal * Math.sin(angle), midPoint.getY() - halfDiagonal * Math.cos(angle));

        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p3);
        points.add(p2);
        points.add(p4);

        return new Polygon(points, polygonStyle);
    }

    @Override
    public String toSvg() {
        if (points.size() >= 3) {
            String svgCode = "<svg height=\"220\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    "  <polygon points=\"";

            for (Point p : points) {
                svgCode += p.getX() + "," + p.getY() + " ";
            }

            svgCode = svgCode.trim();
            svgCode += "\"\n" +
                    shapeStyle.toSvg() + " />\n" +
                    "</svg>";

            return svgCode;
        }
        else {
            return "";
        }
    }
}
