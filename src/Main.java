import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points1 = new ArrayList<>();
        points1.add(new Point(100, 10));
        points1.add(new Point(150, 190));
        points1.add(new Point(50, 190));

        Style style1 = new Style("lime", "purple", 3.0);
        Polygon polygon1 = new Polygon(points1, style1);

        ArrayList<Point> points2 = new ArrayList<>();
        points2.add(new Point(200, 20));
        points2.add(new Point(250, 200));
        points2.add(new Point(150, 200));

        Style style2 = new Style("blue", "red", 2.0);
        Polygon polygon2 = new Polygon(points2, style2);

        Point start = new Point(100, 100);
        Point end = new Point(200, 200);
        Segment diagonal = new Segment(start, end);

        Style squareStyle = new Style("violet", "green", 4.0);
        Polygon square = Polygon.square(diagonal, squareStyle);

        Point center = new Point(100, 100);
        double radiusLengthX = 10.0;
        double radiusLengthY = 10.0;

        Style ellipseStyle = new Style("blue", "yellow", 5.0);
        Ellipse ellipse = new Ellipse(ellipseStyle, center, radiusLengthX, radiusLengthY);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(polygon1);
        shapes.add(polygon2);
        shapes.add(square);
        shapes.add(ellipse);

        SvgScene scene = new SvgScene(shapes);

        scene.save("scene.html");
    }
}