package Generator;

public class Knot
{
    public enum KnotDirection
    {
        LEFT,
        RIGHT,
        LEFT_ANGLE,
        RIGHT_ANGLE,
        LEFT_EMPTY,
        RIGHT_EMPTY
    }

    private Rope[] ropesUp;
    private KnotDirection direction;
    private Rope[] ropesDown;

    Knot(Rope[] ropesUp)
    {
        this.ropesUp = ropesUp;
        this.direction = KnotDirection.LEFT;
        this.ropesDown = new Rope[2];
        makeKnot();
    }

    Knot(Rope[] ropesUp, KnotDirection direction)
    {
        this.ropesUp = ropesUp;
        this.direction = direction;
        if (direction == KnotDirection.LEFT_EMPTY || direction == KnotDirection.RIGHT_EMPTY )
            this.ropesDown = new Rope[1];
        else
            this.ropesDown = new Rope[2];
        makeKnot();
    }

    Knot(Rope[] ropesUp, KnotDirection direction, Rope[] ropesDown)
    {
        this.ropesUp = ropesUp;
        this.direction = direction;
        this.ropesDown = ropesDown;
    }

    void makeKnot()
    {
        if (direction == KnotDirection.LEFT || direction == KnotDirection.RIGHT)
        {
            ropesDown[1] = ropesUp[0];
            ropesDown[0] = ropesUp[1];
        }
        else
            ropesDown = ropesUp;
    }

    public Rope[] getRopesUp() {
        return ropesUp;
    }

    public void setRopesUp(Rope[] ropesUp) {
        this.ropesUp = ropesUp;
    }

    public KnotDirection getDirection() {
        return direction;
    }

    public void setDirection(KnotDirection direction) {
        this.direction = direction;
    }
}
