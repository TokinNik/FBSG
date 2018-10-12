import Generator.Scheme;
import SchemeView.ConsoleSchemeViewer;

public class Main
{
    public static void main(String[] args)
    {
        ConsoleSchemeViewer viewer = new ConsoleSchemeViewer(new Scheme(1));
        viewer.testScheme();
        viewer.viewScheme();
    }
}
