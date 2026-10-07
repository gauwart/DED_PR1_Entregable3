package edu.uoc.ds.adt;

public class Segment {
    private int x, y;

    public Segment(int x, int y) { this.x = x; this.y = y; }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Segment)) return false;
        Segment s = (Segment) o;
        return x == s.x && y == s.y;
    }
}
