package edu.uoc.ds.adt;

import edu.uoc.ds.adt.exceptions.SnakeOutOfBoundsException;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static edu.uoc.ds.adt.ISnakeGame.Direction.RIGHT;
import static edu.uoc.ds.adt.ISnakeGame.Direction.UP;

public class SnakeGameTest {

    SnakeGame snakeGame;


    @Before
    public void setUp() {
        this.snakeGame = new SnakeGame();
        int[][] segments = {
                {5, 5},
                {4, 5},
                {3, 5}
        };
        this.snakeGame.addSegments(segments);

        Assert.assertEquals(3, this.snakeGame.size());

        this.snakeGame.addFood(8,5);
        this.snakeGame.addFood(5,0);


        Assert.assertEquals('@', this.snakeGame.getSegment(8,5));
        Assert.assertEquals('@', this.snakeGame.getSegment(5,0));

        Assert.assertEquals('S', this.snakeGame.getSegment(5,5));
        Assert.assertEquals('S', this.snakeGame.getSegment(4,5));
        Assert.assertEquals('S', this.snakeGame.getSegment(3,5));

        Assert.assertEquals(new Segment(5,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(3,5), this.snakeGame.tail());

    }

    @After
    public void release() {
        this.snakeGame = null;
    }


    @org.junit.Test
    public void moveTest1() throws Exception {
        System.out.println(this.snakeGame);
        Assert.assertEquals(new Segment(5,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(3,5), this.snakeGame.tail());
        this.snakeGame.move(RIGHT);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(6,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(4,5), this.snakeGame.tail());

        this.snakeGame.move(RIGHT);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(7,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,5), this.snakeGame.tail());

        this.snakeGame.move(RIGHT);
        System.out.println(this.snakeGame);

        Assert.assertEquals(4, this.snakeGame.size());
        Assert.assertEquals(new Segment(8,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,5), this.snakeGame.tail());

        this.snakeGame.move(RIGHT);
        System.out.println(this.snakeGame);

        Assert.assertEquals(4, this.snakeGame.size());
        Assert.assertEquals(new Segment(9,5), this.snakeGame.head());
        Assert.assertEquals(new Segment(6,5), this.snakeGame.tail());

        Assert.assertThrows(SnakeOutOfBoundsException.class, () -> this.snakeGame.move(RIGHT));

    }


    @org.junit.Test
    public void moveTest2() throws Exception {
        System.out.println(this.snakeGame);
        this.snakeGame.move(UP);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(5,4), this.snakeGame.head());
        Assert.assertEquals(new Segment(4,5), this.snakeGame.tail());

        this.snakeGame.move(UP);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(5,3), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,5), this.snakeGame.tail());

        this.snakeGame.move(UP);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(5,2), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,4), this.snakeGame.tail());

        this.snakeGame.move(UP);
        System.out.println(this.snakeGame);

        Assert.assertEquals(3, this.snakeGame.size());
        Assert.assertEquals(new Segment(5,1), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,3), this.snakeGame.tail());

        this.snakeGame.move(UP);
        System.out.println(this.snakeGame);

        Assert.assertEquals(4, this.snakeGame.size());
        Assert.assertEquals(new Segment(5,0), this.snakeGame.head());
        Assert.assertEquals(new Segment(5,3), this.snakeGame.tail());

        Assert.assertThrows(SnakeOutOfBoundsException.class, () -> this.snakeGame.move(UP));

    }

    @Test
    public void logEntryTest() throws Exception {
        moveTest1();
        Iterator<LogEntry> it = this.snakeGame.logEntries();

        Assert.assertTrue(it.hasNext());
        LogEntry entry = it.next();
        Assert.assertEquals(5, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("MOVE", entry.getMsg());

        Assert.assertTrue(it.hasNext());
        entry = it.next();
        Assert.assertEquals(6, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("MOVE", entry.getMsg());

        Assert.assertTrue(it.hasNext());
        entry = it.next();
        Assert.assertEquals(7, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("EAT", entry.getMsg());

        Assert.assertTrue(it.hasNext());
        entry = it.next();
        Assert.assertEquals(7, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("MOVE", entry.getMsg());

        Assert.assertTrue(it.hasNext());
        entry = it.next();
        Assert.assertEquals(8, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("MOVE", entry.getMsg());

        Assert.assertTrue(it.hasNext());
        entry = it.next();
        Assert.assertEquals(9, entry.getX());
        Assert.assertEquals(5, entry.getY());
        Assert.assertEquals(RIGHT, entry.getDirection());
        Assert.assertEquals("COLLISION", entry.getMsg());

        Assert.assertFalse(it.hasNext());

    }

}
