package edu.uoc.ds.adt;

import edu.uoc.ds.adt.exceptions.SnakeOutOfBoundsException;
import edu.uoc.ds.adt.model.Snake;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;

public class SnakeGame implements ISnakeGame {

    private char[][] board;
    private Snake snake;
    private Queue<LogEntry> log;

    public SnakeGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        snake = new Snake();
        log = new QueueArrayImpl<LogEntry>(MAX_LOG_SIZE);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    @Override
    public void addSegment(int x, int y) {
        snake.addSegment(x, y);
        board[x][y] = 'S';
    }

    @Override
    public void addSegments(int[][] segments) {
        for (int i = 0; i < segments.length; i++) {
            addSegment(segments[i][0], segments[i][1]);
        }
    }

    @Override
    public int size() {
        return snake.size();
    }

    @Override
    public void addFood(int x, int y) {
        board[x][y] = '@';
    }

    @Override
    public boolean hasFoodAt(int x, int y) {
        return board[x][y] == '@';
    }

    @Override
    public char getSegment(int x, int y) {
        return board[x][y];
    }

    @Override
    public Segment head() {
        return snake.head();
    }

    @Override
    public Segment tail() {
        return snake.tail();
    }

    private boolean isInside(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    @Override
    public void move(Direction direction) throws SnakeOutOfBoundsException {
        Segment head = snake.head();
        int x = head.getX();
        int y = head.getY();
        int newX = x + direction.getDx();
        int newY = y + direction.getDy();

        if (!isInside(newX, newY)) {
            log.add(new LogEntry(x, y, direction, "COLLISION"));
            throw new SnakeOutOfBoundsException();
        }

        boolean food = hasFoodAt(newX, newY);

        if (food) {
            log.add(new LogEntry(x, y, direction, "EAT"));
        }
        log.add(new LogEntry(x, y, direction, "MOVE"));

        if (!food) {
            Segment tail = snake.deleteTail();
            board[tail.getX()][tail.getY()] = '.';
        }

        snake.addHead(new Segment(newX, newY));
        board[newX][newY] = 'S';
    }

    @Override
    public Iterator<LogEntry> logEntries() {
        return log.values();
    }

    @Override
    public String toString() {
        String result = "";
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                result += board[x][y];
            }
            result += "\n";
        }
        return result;
    }
}