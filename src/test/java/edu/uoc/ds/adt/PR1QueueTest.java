package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR1QueueTest {
    PR1Queue pr1q;

    private void fillQueue() {
        for (int x=0; x < 15; x++) {
            pr1q.add(Math.f(x));
        }
    }
    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();

        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(PR1Queue.CAPACITY, this.pr1q.getQueue().size());
        Assert.assertEquals(2, pr1q.poll());
        Assert.assertEquals(6, pr1q.poll());
        Assert.assertEquals(12, pr1q.poll());
        Assert.assertEquals(20, pr1q.poll());
        Assert.assertEquals(30, pr1q.poll());
        Assert.assertEquals(42, pr1q.poll());
        Assert.assertEquals(56, pr1q.poll());
        Assert.assertEquals(72, pr1q.poll());
        Assert.assertEquals(90, pr1q.poll());
        Assert.assertEquals(110, pr1q.poll());
        Assert.assertEquals(132, pr1q.poll());
        Assert.assertEquals(156, pr1q.poll());
        Assert.assertEquals(182, pr1q.poll());
        Assert.assertEquals(210, pr1q.poll());
        Assert.assertEquals(240, pr1q.poll());
        assertEquals(0, this.pr1q.getQueue().size());
    }

}
