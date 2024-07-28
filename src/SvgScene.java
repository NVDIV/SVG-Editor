import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SvgScene {
    private ArrayList<Shape> shapes;

    public SvgScene(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void save(String path) {
        String htmlCode = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n\n";

        for (Shape p : shapes) {
            htmlCode += p.toSvg() + "\n";
        }

        htmlCode += "</body>\n" +
                "</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(htmlCode);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
