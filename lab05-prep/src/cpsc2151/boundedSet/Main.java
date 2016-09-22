package cpsc2151.boundedSet;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class Main {
    public static void main(String[] args)
    {
        IBoundedSet b1 = new BoundedSetBinSearch(20);
        IBoundedSet b2 = new BoundedSetBinSearch(20);

        intersection(b1, b2);


    }

    public static IBoundedSet intersection(IBoundedSet bs1, IBoundedSet bs2)
    {
        IBoundedSet intersected = new BoundedSetBinSearch(20);

        for(int i = 0; i < bs1.sizeOfSet(); i++)
        {
            for(int z = 0; z < bs2.sizeOfSet(); z++)
            {
                if(bs1.contents[i] == bs2.contents[z])
                {
                    intersected.insert(bs1.contents[i]);
                }
            }
        }
        return(intersected);

    }
}
