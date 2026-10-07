package edu.uoc.ds.adt.model;
import edu.uoc.ds.adt.Segment;

public interface ISnake {
    Segment head();
    Segment tail();
    void addSegment(int x, int y);
    void addHead(Segment newHead);
    Segment deleteTail();

    int size();

}
