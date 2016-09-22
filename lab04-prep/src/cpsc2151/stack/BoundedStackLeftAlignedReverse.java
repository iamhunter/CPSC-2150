package cpsc2151.stack;

import java.util.Arrays;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class BoundedStackLeftAlignedReverse {
    Integer[] contents;
    int count;

    public BoundedStackLeftAlignedReverse(int maximum)
    {
        contents = new Integer[maximum];
        count = 0;
    }

    public BoundedStackLeftAlignedReverse(int size, Integer[] initial) {
        this.contents = new Integer[size];
        this.count = initial.length;
        for(int i = 0; i < this.count; ++i)
            this.contents[i] = initial[i];
    }

    public boolean equals(Object o) {
        // Check for type equality.
        if(!(o instanceof BoundedStack)) return false;
        // The object is of the correct type! Cast it!
        BoundedStack rhs = (BoundedStack) o;
        // Check for “count” equality.
        if(this.count != rhs.count) return false;
        // Check for “contents” equality. Remember a stack is unordered.
        for(int i = 0; i < this.count; ++i) {
            if(!this.contents[i].equals(rhs.contents[i])) return false;
        }
        return true;
    }

    /**
     * @param element Element to be pushed onto the stack.
     * @requires
     * element != null and [The stack is not full.]
     * @ensures
     * [element is unchanged.] and [element is pushed on top of the stack.]
     */
    public void push(Integer element)
    {
        Integer[] temp = new Integer[getDepth()];

        for(int i = 0; i < getDepth()+1; i++)
        {
            temp[i+1] = contents[i];
        }
        temp[0] = element;

        contents = temp;
    }

    /**
     * @return Element popped off the stack.
     * @requires
     * element != null and [The stack is not empty.]
     * @ensures
     * [The stack is popped.] and [The popped element is returned.]
     */
    public Integer pop()
    {
        Integer tempint = contents[0];

        count--;

        Integer[] temp = new Integer[getDepth()];

        for(int i = 0; i < getDepth()+1; i++)
        {
            temp[i] = contents[i+1];
        }
        contents = temp;

        return tempint;
    }

    /**
     * @return The depth of the stack.
     * @ensures
     * [The stack is unchanged.] and [The size of the stack is returned.]
     */
    public int getDepth()
    {
        return contents[count - 1];
    }

    /**
     * @return element Element on top of the stack.
     * @requires
     * [The stack is not empty.]
     * @ensures
     * [The stack is unchanged.] and [The top of the stack is returned.]
     */
    public Integer peek()
    {
        return contents[count-1];
    }

    /**
     * @param element Element to find in the set.
     * @return Indicator of element presence in the set.
     * @requires element != null
     * @ensures
     * [element is unchanged.] and
     * [The stack is unchanged.] and
     * [The return is true if element was found in the stack; otherwise
     * the return is false.]
     */
    public boolean contains(Integer element)
    {
        for(int i = 0; i < count; i++)
        {
            if(contents[i] == element)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @return The stringified contents of the set.
     * [The stack is unchanged.] and
     * [The contents of the stack are returned as a string, ordered from
     * top to bottom.]
     */
    public String toString()
    {
        return Arrays.toString(contents);
    }
}
