package Generator;

import java.util.ArrayList;

public class Editor
{
    private Scheme scheme;
    private boolean isChanged = false;

    Editor(Scheme scheme)
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
        int preSize = scheme.getRopeUp().size()+1;
        Rope newRope = new Rope(preSize);
        scheme.getRopeUp().add(newRope);
        ArrayList<Rope> ropesUp = scheme.getRopeUp();
        for (Row row :scheme.getRows())
        {
            switch (row.getType())
            {
                case FULL:
                    row.setType(Row.RowType.OPEN_RIGHT);
                    row.getKnots().add(new Knot(new Rope[]{ropesUp.get(preSize)}, Knot.KnotDirection.RIGHT_EMPTY));
                    break;
                case NOT_FULL:
                    break;
            }
            

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
