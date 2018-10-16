package Generator;

import java.util.ArrayList;

public class Editor
{
    private Scheme scheme;
    private boolean isChanged = false;

    public Editor(Scheme scheme)
    {
        this.scheme = scheme;
    }

    public void setScheme(Scheme scheme)
    {
        if (isChanged)
        {
            System.out.println("Scheme data not save!");
        }
        this.scheme = scheme;
    }

    public void addRope()
    {
        isChanged = true;
        int preSize = scheme.getRopeUp().size()-1;
        Rope newRope = new Rope(preSize+1);
        scheme.getRopeUp().add(newRope);
        scheme.getRopeDown().add(newRope);
        boolean first = true;
        int i = 0;
        for (Row row :scheme.getRows())
        {
            switch (row.getType())
            {
                case FULL:
                    row.setType(Row.RowType.OPEN_RIGHT);
                    row.getKnots().add(new Knot(Knot.KnotDirection.RIGHT_EMPTY));
                    break;
                case NOT_FULL:
                    row.setType(Row.RowType.OPEN_LEFT);
                    row.getKnots().get(row.getKnots().size()-1).setDirection(Knot.KnotDirection.LEFT);
                    break;
                case OPEN_RIGHT:
                    row.setType(Row.RowType.FULL);
                    row.getKnots().get(row.getKnots().size()-1).setDirection(Knot.KnotDirection.LEFT);
                    break;
                case OPEN_LEFT:
                    row.setType(Row.RowType.NOT_FULL);
                    row.getKnots().add(new Knot(Knot.KnotDirection.RIGHT_EMPTY));
                    break;
            }
            ArrayList<Integer> ropesUp = new ArrayList<>();
            if (first)
            {
                first = false;
                ropesUp.addAll(scheme.getRows().get(0).getRopesUp());
                ropesUp.add(newRope.getId());
            }
            else
            {
                ropesUp.clear();
                ropesUp.addAll(scheme.getRows().get(i-1).getRopesDown());
            }
            row.setRopesUp(ropesUp);
            row.setRopesDown(ropesUp);
            row.makeRow();
            i++;
        }
        ArrayList<Rope> buf1 = scheme.getRopeUp();
        ArrayList<Rope> buf = new ArrayList<>();
        ArrayList<Integer> buf3 = scheme.getRows().get(scheme.getRows().size()-1).getRopesDown();
        for (i = 0; i < buf1.size(); i++)
        {
            buf.add(buf1.get(buf3.get(i)));
        }
        scheme.getRopeDown().clear();
        scheme.getRopeDown().addAll(buf);
    }

    public void decRope()
    {

    }

    public void addRow()
    {

    }

    public void decRow()
    {

    }

    public void changeRopeCol(Rope rope, Colour newColour)
    {

    }

    public void changeKnotDirection(Knot knot, Knot.KnotDirection newDirection)
    {

    }
}
