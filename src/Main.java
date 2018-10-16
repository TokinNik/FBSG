import Generator.Editor;
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
        editor.addRope();
        viewer.viewScheme();
        editor.addRope();
        viewer.viewScheme();
        editor.addRope();
        viewer.viewScheme();
        editor.addRope();
        viewer.viewScheme();

    }
}
