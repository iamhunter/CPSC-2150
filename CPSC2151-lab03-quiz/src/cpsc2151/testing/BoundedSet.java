package cpsc2151.testing;

/**
 * Created by andrewmarionhunter on 9/7/16.
 */
public class BoundedSet
{

    private Integer[] contents;
    private int count;

    public BoundedSet(int size)
    {
        contents = new Integer[size];
        count = 0;
    }

    public void insert(Integer element)
    {
        contents[count++] = element;
    }

    public void remove(Integer element)
    {
        int j = 0;
        for(int i = 0; i < count; i++)
        {
            if(contents[i] .equals(element))
            {
                j = i;
                break;
            }
            for(; j < count; j++)
            {
                contents[j] = contents[j + 1];
            }
            count--;
        }
    }
    public boolean contains(Integer element)
    {
        for(int x = 0; x < count; x++)
        {
            if(contents[x] == element)
            {
                return true;
            }
        }
        return false;
    }

    public int sizeOfSet()
    {
        int counter = 0;
        for(int x = 0; x < count; x++)
        {
            if(contents[x] != null)
            {
                counter++;
            }
        }


        return counter;
    }
    public Integer removeAny()
    {

        Integer tempInt = contents[0];

        contents[0] = null;

        for(int j = 0; j < count; j++)
        {
            contents[j] = contents[j + 1];
        }
        count--;

        return tempInt;
    }
    public  String toString1() {
        String tempString = " ";

        for(int x = 0; x < count; x++)
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
        return tempString;
    }
}
