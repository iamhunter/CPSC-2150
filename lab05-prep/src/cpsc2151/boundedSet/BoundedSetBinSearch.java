package cpsc2151.boundedSet;


/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class BoundedSetBinSearch implements IBoundedSet
{
    /**
      * @invariant contents is always in increasing order from [0, count).
      */
    private Integer[] contents;
    public int count;


    public BoundedSetBinSearch(int size)
    {
        count = 0;
        contents = new Integer[size];
    }

    public void insert(Integer element)
    {
        contents[count++] = element;

        sort();
    }

    public void sort()
    {
        for (int i = (count - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (contents[j - 1] > contents[j]) {
                    int temp = contents[j - 1];
                    contents[j - 1] = contents[j];
                    contents[j] = temp;
                }
            }
        }
    }

    public int sizeOfSet()
    {
        return count;
    }

    public Integer removeAny()
    {
        return contents[--count];
    }

    public boolean equals(Object o)
    {
        for(int i = 0; i < count; ++i)
        {
            if(contents[i] == o)
            {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        String tempString = " ";

        for(int x = 0; x < contents.length; x++)
        {
            if(contents[x] == contents[0])
            {
                if(contents[x] != null) {
                    tempString = Integer.toString(contents[x]);
                }
            }

            else if(contents[x]!= null)
            {
                tempString += Integer.toString(contents[x]);
            }
        }
        return tempString;    }

    public boolean contains(Integer element)
    {
        for(int i = 0; i < count; ++i)
            if(contents[i].equals(element)) return true;
        return false;
    }

    public void remove(Integer element)
    {
        int min = 0;
        int max = count;
        int middle = count/2;
        boolean done = false;
        while(!done)
        {
            if(contents[middle] == element)
            {
                contents[middle] = null;
                done = true;
            }
            else if(element < contents[middle])
            {
                max = middle;
                middle = (max + min)/2;
            }
            else
            {
                min = middle;
                middle = (max + min)/2;
            }
        }
    }
}
