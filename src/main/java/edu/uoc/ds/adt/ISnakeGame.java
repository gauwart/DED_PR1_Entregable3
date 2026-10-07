package edu.uoc.ds.adt;

import edu.uoc.ds.adt.exceptions.SnakeOutOfBoundsException;
import edu.uoc.ds.traversal.Iterator;

public interface ISnakeGame {
    public static final int BOARD_SIZE = 10;
    public static final int MAX_LOG_SIZE = 800;


    enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }

    public void addSegment(int x, int y);
    public void addSegments(int[][] segments);
    public int size();
    void addFood(int x, int y);
    boolean hasFoodAt(int x, int y);

    char getSegment(int x, int y);
    Segment head();
    Segment tail();
    void move(Direction direction) throws SnakeOutOfBoundsException;
    Iterator<LogEntry> logEntries();
}
