package cpsc2151.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrewmarionhunter on 9/14/16.
 */
public class BoundedSetTest {
    private BoundedSet empty, partial, biggerArray, full;

    @Before
    public void setUp()
    {
        empty = new BoundedSet(6);
        partial = new BoundedSet(6, new Integer[]{1, 2, 3});
        biggerArray = new BoundedSet(100, new Integer[]{1, 2, 3});
        full = new BoundedSet(6, new Integer[]{1, 2, 3, 4, 5, 6});


    }

    @Test
    public void insert()
    {
        //empty
        empty.insert(new Integer(1));
        Assert.assertEquals(new Integer(1), empty);

        empty.insert(new Integer(2));
        Assert.assertEquals(new Integer[]{1, 2}, empty);

        empty.insert(new Integer(2));
        Assert.assertEquals(new Integer[]{1, 2, 3}, empty);

        //partial
        partial.insert(new Integer(4));
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3, 4}),partial);

        partial.insert(new Integer(5));
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3, 4, 5}),partial);

        partial.insert(new Integer(6));
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3, 4, 5, 6}),partial);

        //biggerArray
        biggerArray.insert(new Integer(4));
        Assert.assertEquals(new BoundedSet(100, new Integer[]{1, 2, 3, 4}),partial);

        biggerArray.insert(new Integer(5));
        Assert.assertEquals(new BoundedSet(100, new Integer[]{1, 2, 3, 4, 5}),partial);

        biggerArray.insert(new Integer(6));
        Assert.assertEquals(new BoundedSet(100, new Integer[]{1, 2, 3, 4, 5, 6}),partial);

    }

    @Test
    public void remove()
    {
        //partial
        partial.remove(3);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2}), partial);

        partial.remove(2);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1}), partial);

        partial.remove(1);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{}), partial);

        //biggerArray
        biggerArray.remove(3);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2}), biggerArray);

        biggerArray.remove(2);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1}), biggerArray);

        biggerArray.remove(1);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{}), biggerArray);

        //full
        full.remove(6);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3, 4, 5}), full);

        full.remove(5);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3, 4}), full);

        full.remove(4);
        Assert.assertEquals(new BoundedSet(6, new Integer[]{1, 2, 3}), full);
    }

}