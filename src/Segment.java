public class Segment {
    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public double getSegmentLength() {
        return Math.sqrt(Math.pow((endPoint.x - startPoint.x), 2) + Math.pow((endPoint.y - startPoint.x), 2));
    }

    public String toSvg() {
        String svgCode = "<svg height=\"200\" width=\"300\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "  <line x1=\"" + startPoint.x + "\" y1=\"" + startPoint.y + "\" x2=\"" + endPoint.x + "\" y2=\"" + endPoint.y + "\" style=\"stroke:red;stroke-width:2\" />\n" +
                "</svg>";

        return svgCode;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2));
    }

    public Segment perpendicular() {
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();
        Point midPoint = new Point((startPoint.getX() + endPoint.getX()) / 2, (startPoint.getY() + endPoint.getY()) / 2);
        Point perpStart = new Point(midPoint.getX() - dy / 2, midPoint.getY() + dx / 2);
        Point perpEnd = new Point(midPoint.getX() + dy / 2, midPoint.getY() - dx / 2);
        return new Segment(perpStart, perpEnd);
    }

    public Segment perpendicular(double length) {
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();
        double currentLength = getLength();
        double scale = length / currentLength;
        double perpDx = -dy * scale;
        double perpDy = dx * scale;
        Point midPoint = new Point((startPoint.getX() + endPoint.getX()) / 2, (startPoint.getY() + endPoint.getY()) / 2);
        Point perpStart = new Point(midPoint.getX() + perpDx / 2, midPoint.getY() + perpDy / 2);
        Point perpEnd = new Point(midPoint.getX() - perpDx / 2, midPoint.getY() - perpDy / 2);
        return new Segment(perpStart, perpEnd);
    }
}
