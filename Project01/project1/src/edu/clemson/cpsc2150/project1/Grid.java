package edu.clemson.cpsc2150.project1;

/**
 * Created by andrewmarionhunter on 9/7/16.
 */
public class Grid {
    int gameGrid[][];

    /**
     * @return void
     * @requires
     * rows != null
     * columns != null
     * [Proper number of rows and columns]
     * @ensures <pre>
     * [Dimensions are set to 10 properly]
     * </pre>
     */
    void setGridDimensions (int rows, int columns)
    {
        gameGrid = new int[rows][columns];
    }


    /**
     * @return void
     * @requires
     * rows != null
     * columns != null
     * @ensures <pre>
     * [Dimensions are set to 10 properly]
     * </pre>
     */
    void placeShip (int row, int column, int length, int direction)
    {
        int[][] theBoard = new int[10][10];
        theBoard[row][column] = 2;
    }

    /**
     * @return Identification for ship placement
     * @requires
     * rows != null
     * columns != null
     * @ensures <pre>
     * [Conflicting ship placement is checked properly]
     * </pre>
     */
    boolean isConflictingShipPlacement (int row, int column, int length, int direction)
    {
        if(direction == 'd')
        {
            for(int z = 0; z < length; z++)
            {
                if((row) > 10)
                {
                    return false;
                }
                else if((column+ z) > 10) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @return Identification for shot
     * @requires
     * rows != null
     * columns != null
     * @ensures <pre>
     * [Checks is shot hits, misses, or hits and sinks]
     * </pre>
     */
    int shoot(int row, int column){
        /*– This method should handle a player’s shot at a coordinate on the ocean grid. The return
        value should be as follows:
        ∗ return -1 if the shot misses
        ∗ return 0 if the shot hits
        ∗ return 1 if the shot hits and sinks a ship
        */
        int hit = -1;
        int miss = 0;
        int sink = 1;

        int[][] theBoard = new int[10][10];
        if(theBoard[row][column] == hit)
        {
            return 0;
        }
        else if(theBoard[row][column] == miss)
        {
            return -1;
        }
        else if(theBoard[row][column] == sink)
        {
            return 1;
        }
        return 0;
    }

    /**
     * @return Identification for shot
     * @requires
     * rows != null
     * columns != null
     * @ensures <pre>
     * [Checks the shot, returns true if it has already been shot at]
     * </pre>
     */
    boolean hasBeenAttempted (int row, int column) {
        //TODO: –This method returns true if the player has already attempted a shot at the specified coordinates(otherwise false).

        int[][] theBoard = new int[10][10];
        return theBoard[row][column] == 3;
    }

    /**
     * @return void
     * @requires
     * board != null
     * [Proper gameboard]
     * @ensures <pre>
     * [Gameboard is printed properly]
     * </pre>
     */
    void displayGrid(boolean showShips)
    {
        //Print top numbers
        System.out.print("  ");
        for (int x  = 0; x < 10; x++)
        {
            System.out.print(x + " ");
        }
        System.out.println();

        //Print game board
        for (int x = 0; x < 10; x++)
        {
            //Print side numbers
            System.out.print(x + " ");
            for(int y = 0; y < 10; y ++)
            {
                System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
