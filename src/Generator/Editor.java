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
        ArrayList<Integer> ropesUp = scheme.getRows().get(0).getRopesUp();
        ropesUp.add(newRope.getId());
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
                    break;
            }
            row.setRopesUp(ropesUp);
            row.setRopesDown(ropesUp);
            row.makeRow();
            ropesUp = row.getRopesDown();
        }
        ArrayList<Rope> buf = new ArrayList<>();
        ArrayList<Rope> buf1 = scheme.getRopeDown();
        buf.addAll(scheme.getRopeDown());
        for (int i = 0; i < buf1.size()-1; i++)
        {
            buf1.set(i, buf.get(ropesUp.get(i)));
        }
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
