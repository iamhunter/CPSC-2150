package cpsc2151.set;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoundedSet extends TestCase
{
    private BoundedSet set;

    @Before
    public void setUp(){set = new BoundedSet(3);}

    @After
    public void tearDown(){set = null;}

    @Test
    public void testInsert()
    {
        set.insert(3);
        set.insert(2);
        set.insert(1000000000);
        set.insert(1);
        

    }




}

