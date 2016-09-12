package cpsc2151.testing;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/7/16.
 */
public class Main {
    public static void main(String[] args)
    {
        BoundedSet bs =  new BoundedSet(20);

        bs.insert(3);
        bs.insert(4);


        System.out.println(bs.sizeOfSet());
        System.out.println(bs.toString1());



    }
}
