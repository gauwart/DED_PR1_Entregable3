package edu.uoc.ds.adt.model;

import edu.uoc.ds.adt.Segment;
import edu.uoc.ds.adt.sequential.LinkedList;

public class Snake implements ISnake {
    private LinkedList<Segment> segments = new LinkedList<>();

    public Segment head() { return segments.peekFirst(); }
    public Segment tail() { return segments.peekLast(); }
    public void addSegment(int x, int y) { segments.insertEnd(new Segment(x, y)); }
    public void addHead(Segment newHead) { segments.insertBeginning(newHead); }
    public Segment deleteTail() { return segments.deleteLast(); }
    public int size() { return segments.size(); }
}