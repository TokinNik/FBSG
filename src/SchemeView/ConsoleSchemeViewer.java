package SchemeView;

import Generator.Knot;
import Generator.Rope;
import Generator.Row;
import Generator.Scheme;

public class ConsoleSchemeViewer
{
    private Scheme scheme;

    public ConsoleSchemeViewer(Scheme scheme)
    {
        this.scheme = scheme;
    }

    public void testScheme()
    {
        System.out.println("==|| Test Scheme #0 NoName ||==");
        System.out.println();
        System.out.println("1|2|3|4|5|6");
        System.out.println(" /   /   /      -1");
        System.out.println("2|1|4|3|6|5");
        System.out.println("/  /   /   \\0    -2");
        System.out.println("2|4|1|6|3|5");
        System.out.println();
        System.out.println("==|| End ||==");
    }

    public void viewScheme()
    {
        System.out.println("==|| Scheme #" + scheme.getId() + " - " + scheme.getName() + " ||==");
        System.out.println();
        for (Row row: scheme.getRows())
        {
            StringBuilder ropesStr = new StringBuilder();
            StringBuilder knotsStr = new StringBuilder();
            boolean first = true;
            for (Knot knot: row.getKnots())
            {
                Rope[] ropes = knot.getRopesUp();
                switch (knot.getDirection())
                {
                    case LEFT:
                        if (!first)
                            knotsStr.append("  ");
                        knotsStr.append(" /");
                        ropesStr.append(String.valueOf(ropes[0].getId())).append('|').append(String.valueOf(ropes[1].getId())).append('|');
                        break;
                    case RIGHT:
                        if (!first)
                            knotsStr.append("  ");
                        knotsStr.append(" \\");
                        ropesStr.append(String.valueOf(ropes[0].getId())).append('|').append(String.valueOf(ropes[1].getId())).append('|');
                        break;
                    case LEFT_ANGLE:
                        if (!first)
                            knotsStr.append("  ");
                        knotsStr.append(" >");
                        ropesStr.append(String.valueOf(ropes[0].getId())).append('|').append(String.valueOf(ropes[1].getId())).append('|');
                        break;
                    case RIGHT_ANGLE:
                        if (!first)
                            knotsStr.append("  ");
                        knotsStr.append(" <");
                        ropesStr.append(String.valueOf(ropes[0])).append('|').append(String.valueOf(ropes[1].getId())).append('|');
                        break;
                    case RIGHT_EMPTY:
                        knotsStr.append("  \\0");
                        ropesStr.append(String.valueOf(ropes[0].getId()));
                        break;
                    case LEFT_EMPTY:
                        knotsStr.append("/0");
                        ropesStr.append(String.valueOf(ropes[0].getId())).append('|');
                        break;
                }
                first = false;
            }
            System.out.println(ropesStr.toString());
            knotsStr.append("    [").append(String.valueOf(row.getId()));
            System.out.println(knotsStr.toString());
        }
        for (Rope rope :scheme.getRopeDown())
        {
            System.out.print(rope.getId() + "|");
        }
        System.out.println();
        System.out.println();
        System.out.println("==|| End ||==");
    }


    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }
}
