package cpsc2151.boundedSet;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public interface IBoundedSet
{
/**
  * @param element Element to be inserted into the set.
  * @requires
  * element != null and [element is not in the set.] and
  * [The set is not full.]
  * @ensures <pre>
  * [element is unchanged.] and [element is inserted into the set.]
  * </pre>
  */
    public void insert(Integer element);
/**
  * @param element Element to find in the set.
  * @return Indicator of element presence in the set.
  * @requires
  * element != null
  * @ensures <pre>
  * [element is unchanged.] and
  * [The return is true if element was found in the set; otherwise
  * the return is false.]
  * </pre>
  */
    public boolean contains(Integer element);
/**
  * @param element Element to remove from the set.
  * @requires
  * element != null and [element is in the set.]
  * @ensures <pre>
  * [element is unchanged.] and [element is removed from the set.]
  * </pre>
  */
    public void remove(Integer element);
/**
  * @return The size of the set.
  * @requires true
  * @ensures <pre>
  * [The contents of the set are unchanged.] and
  * [The return equals the number of elements in the set.]
  * </pre>
  */
    public int sizeOfSet();
/**
  * @return The element removed from the set.
  * @requires [The set is not empty.]
  * @ensures <pre>
  * [An arbitrarily chosen element is removed from the set; this element
  * is returned to the caller.]
  * </pre>
  */
    public Integer removeAny();

}
