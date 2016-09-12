package cpsc2151.testing;

/**
 * Created by andrewmarionhunter on 9/6/16.
 */
public class BoundedSet
{
    static Integer[] contents;
    int count;


    public BoundedSet(int size)
    {
        contents = new Integer[size];
        count = 0;
    }

    /**
     * @param element Element to be inserted into the set.
     * @requires
     * element != null and [element is not in the set.] and
     * [The set is not full.]
     * @ensures <pre>
     * [element is unchanged.] and [element is inserted into the set.]
     * </pre>
     */
    public static void insert(Integer element)
    {
        for(int x = 0; x < contents.length; x++)
        {
            if(contents[x] == null)
            {
                contents[x] = element;
                return;
            }


        }
    }

    /**
     * @param element Element to find in the set.
     * @return Indicator of element presence in the set.
     * @requires
     * element != null
     * @ensures <pre>
     * [element is unchanged.] and
     * [The return is true if element was found in the set; otherwise
     * the return is false.]
     * </pre>
     */
    public static boolean contains(Integer element)
    {
        for(int x = 0; x < contents.length; x++)
        {
            if(contents[x] == element)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @param element Element to remove from the set.
     * @requires
     * element != null and [element is in the set.]
     * @ensures <pre>
     * [element is unchanged.] and [element is removed from the set.]
     * </pre>
     */
    public static void remove(Integer element)
    {
        for(int x = 0; x < contents.length; x++)
        {
            if(contents[x] == element)
            {
                contents[x] = null;
            }
        }

    }

    /**
     * @return The size of the set.
     * @requires true
     * @ensures <pre>
     * [The contents of the set are unchanged.] and
     * [The return equals the number of elements in the set.]
     * </pre>
     */
    public static int sizeOfSet()
    {
        int counter = 0;
        for(int x = 0; x < contents.length; x++)
        {
            if(contents[x] != null)
            {
                counter++;
            }
        }


        return counter;
    }

    /**
     * @return The element removed from the set.
     * @requires [The set is not empty.]
     * @ensures <pre>
     * [An arbitrarily chosen element is removed from the set; this element
     * is returned to the caller.]
     * </pre>
     */
    public static Integer removeAny()
    {
        Integer tempInt = contents[0];
        contents[0] = null;
        return tempInt;
    }

    /**
     * @return The stringified contents of the set.
     * @requires true
     * @ensures <pre>
     * [The contents of the set are unchanged.] and
     * [The contents of the set are returned as a string.]
     * </pre>
     */
    public static String toString1() {
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
        return tempString;
    }

}
