import Generator.Colour;
import Generator.Editor;
import Generator.Knot;
import Generator.Scheme;
import SchemeView.ConsoleSchemeViewer;

public class Main
{
    public static void main(String[] args)
    {
        Scheme testScheme = new Scheme(1);
        Editor editor = new Editor(testScheme);
        ConsoleSchemeViewer viewer = new ConsoleSchemeViewer(testScheme);
        viewer.testScheme();
        viewer.viewScheme();
        editor.changeKnotDirection(testScheme.getRows().get(0).getKnots().get(2), Knot.KnotDirection.LEFT_ANGLE);
        editor.changeKnotDirection(testScheme.getRows().get(1).getKnots().get(1), Knot.KnotDirection.RIGHT_ANGLE);
        editor.changeRopeCol(2, Colour.BLUE);
        viewer.viewScheme();
        editor.addRope();
        viewer.viewScheme();

    }
}
