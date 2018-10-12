package Generator;

import java.util.ArrayList;

public class Row
{
    static enum RowType
    {
        FULL,
        NOT_FULL,
        OPEN_LEFT,
        OPEN_RIGHT
    }

    private RowType type;
    private ArrayList<Knot> knots = new ArrayList<>();
    private int id;

    Row(int id, ArrayList<Knot> knots, RowType type)
    {
        this.id = id;
        this.knots = knots;
        this.type = type;
    }

    void makeRow()
    {
        for (Knot k: knots)
        {
            k.makeKnot();
        }
    }

    public RowType getType() {
        return type;
    }

    public void setType(RowType type) {
        this.type = type;
    }

    public ArrayList<Knot> getKnots() {
        return knots;
    }

    public void setKnots(ArrayList<Knot> knots) {
        this.knots = knots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
