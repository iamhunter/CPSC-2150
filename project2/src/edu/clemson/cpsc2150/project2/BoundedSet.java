package edu.clemson.cpsc2150.project2;
/**
 * Created by andrewmarionhunter on 9/6/16.
 */
public class BoundedSet implements Grid
{
    private static Integer[] contents;
    private int count;

    private int myRowCount, myColCount;
    private int[][] myStatusGrid;
    private int[][] myShipGrid;
    private int[] myShipHitsRemaining;
    private int myTotalHitsRemaining;

    private int myShipToBePlaced;
    private int myLastSunkShip;


    public BoundedSet()
    {

    }

    public boolean isConflictingShipPlacement (int row, int col, int len, int dir) {
        // loop through each coordinate of the ship to be placed
        for (int i = 0; i < len; ++i) {

            // does the ship go off the grid?
            if (row < 0 || col < 0 || row >= myRowCount || col >= myColCount) {
                return true;
            }

            // does the ship overlap with another ship?
            if (myStatusGrid[row][col] == SHIP) {
                return true;
            }

            // increment the ship coordinates
            if (dir == DOWN) {
                ++row;
            } else {
                ++col;
            }
        }
        return false;
    }



    public void setGridDimensions(int rows, int cols)
    {
        myRowCount = rows;
        myColCount = cols;

        myStatusGrid = new int[myRowCount][myColCount];
        myShipGrid = new int[myRowCount][myColCount];
        myShipHitsRemaining = new int[DEFAULT_SHIP_COUNT];
        myTotalHitsRemaining = 0;
    }

    public void placeShip(Ship ship)
    {

    }

    // see Ship.shoot()
    public Status shoot(Coordinate coord)
    {
        //If hit
        return Status.HIT;
    }

    // returns Ship object representing the last ship
    // which was sunk(null if no ship has been sunk)
    public Ship getLastSunkShip()
    {
        ShipImpl potato = new ShipImpl(ShipType.CARRIER);
        Coordinate x = new Coordinate();
        x.row = 3;
        x.col = 4;

        return potato;
    }

    public boolean hasBeenAttempted(Coordinate coord)
    {
        //If has been attempted
        return true;
    }

    public void displayGrid(boolean showShips)
    {

    }

    // returns true if all ships have been sunk
    // otherwise, false
    public boolean isGameOver()
    {
        return true;
    }




    public BoundedSet(int size)
    {
        contents = new Integer[size];
        count = 0;
    }

    public BoundedSet(int size, Integer[] initial) {
        this.contents = new Integer[size];
        this.count = initial.length;
        for(int i = 0; i < this.count; ++i)
            this.contents[i] = initial[i];
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
