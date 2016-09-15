package cpsc2151.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

/**
 * Created by andrewmarionhunter on 9/14/16.
 */
public class BoundedStackTest {
    private BoundedStack empty, partial, full;

    @Before
    public void setUp()
    {
        empty = new BoundedStack(6);
        partial = new BoundedStack(6, new Integer[]{1, 2, 3});
        full = new BoundedStack(6, new Integer[]{1, 2, 3, 4, 5, 6});
    }
    @Test
    public void testPush()
    {
        //empty
        empty.push(new Integer(1));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1}),empty);

        empty.push(new Integer(2));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2}),empty);

        empty.push(new Integer(3));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3}),empty);


        //partial
        partial.push(new Integer(4));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3, 4}),partial);

        partial.push(new Integer(5));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3, 4, 5}),partial);

        partial.push(new Integer(6));
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3, 4, 5, 6}),partial);
    }

    @Test
    public void testPop()
    {
        Integer returned;

        //partial
        returned = partial.pop();
        Assert.assertEquals(new Integer(3), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2}), partial);

        returned = partial.pop();
        Assert.assertEquals(new Integer(2), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1}), partial);

        returned = partial.pop();
        Assert.assertEquals(new Integer(1), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{}), partial);



        //full
        returned = full.pop();
        Assert.assertEquals(new Integer(6), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3, 4, 5}), full);

        returned = full.pop();
        Assert.assertEquals(new Integer(5), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3, 4}), full);

        returned = full.pop();
        Assert.assertEquals(new Integer(4), returned);
        Assert.assertEquals(new BoundedStack(6, new Integer[]{1, 2, 3}), full);
    }

}