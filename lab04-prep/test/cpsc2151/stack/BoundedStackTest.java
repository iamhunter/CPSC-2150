package cpsc2151.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}