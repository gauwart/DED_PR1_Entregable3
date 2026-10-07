package edu.uoc.ds.adt;

public class LogEntry {
    private int x, y;
    private ISnakeGame.Direction direction;
    private String msg;

    public LogEntry(int x, int y, ISnakeGame.Direction direction, String msg) {
        this.x = x; this.y = y; this.direction = direction; this.msg = msg;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public ISnakeGame.Direction getDirection() { return direction; }
    public String getMsg() { return msg; }
}