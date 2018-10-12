package Generator;

import java.util.ArrayList;

public class Scheme
{
    private ArrayList<Rope> ropeUp = new ArrayList<>();
    private ArrayList<Row> rows = new ArrayList<>();
    private ArrayList<Rope> ropeDown = new ArrayList<>();
    private int id;
    private String name;

    public Scheme(int id)
    {
        this.name = "Name";
        this.id = id;
        ropeUp.add(new Rope(1));
        ropeUp.add(new Rope(2));
        ropeUp.add(new Rope(3));
        ropeUp.add(new Rope(4));
        ropeUp.add(new Rope(5));
        ropeUp.add(new Rope(6));
        ArrayList<Knot> knots = new ArrayList<>();
        knots.add(new Knot(new Rope[]{ropeUp.get(0), ropeUp.get(1)}));
        knots.add(new Knot(new Rope[]{ropeUp.get(2), ropeUp.get(3)}));
        knots.add(new Knot(new Rope[]{ropeUp.get(4), ropeUp.get(5)}));
        rows.add(new Row(1, knots, Row.RowType.FULL));
        ArrayList<Knot> knots1 = new ArrayList<>();
        knots1.add(new Knot(new Rope[]{ropeUp.get(1)}, Knot.KnotDirection.LEFT_EMPTY));
        knots1.add(new Knot(new Rope[]{ropeUp.get(0), ropeUp.get(3)}));
        knots1.add(new Knot(new Rope[]{ropeUp.get(2), ropeUp.get(5)}));
        knots1.add(new Knot(new Rope[]{ropeUp.get(4)}, Knot.KnotDirection.RIGHT_EMPTY));
        rows.add(new Row(2, knots1, Row.RowType.NOT_FULL));
        ropeDown.add(ropeUp.get(1));
        ropeDown.add(ropeUp.get(3));
        ropeDown.add(ropeUp.get(0));
        ropeDown.add(ropeUp.get(5));
        ropeDown.add(ropeUp.get(2));
        ropeDown.add(ropeUp.get(4));
    }

    public Scheme(int id, ArrayList<Rope> ropeUp, ArrayList<Row> rows, ArrayList<Rope> ropeDown)
    {
        this.id = id;
        this.ropeUp = ropeUp;
        this.rows = rows;
        this.ropeDown = ropeDown;
    }


    public ArrayList<Rope> getRopeUp() {
        return ropeUp;
    }

    public void setRopeUp(ArrayList<Rope> ropeUp) {
        this.ropeUp = ropeUp;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Rope> getRopeDown() {
        return ropeDown;
    }

    public void setRopeDown(ArrayList<Rope> ropeDown) {
        this.ropeDown = ropeDown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
