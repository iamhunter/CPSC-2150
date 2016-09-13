package battleShip;

/**
 * Created by andrewmarionhunter on 9/7/16.
 */
public class Grid {
    int gameGrid[][];

    void setGridDimensions (int rows, int columns)
    {
        gameGrid = new int[rows][columns];
    }
    void placeShip (int row, int column, int length, int direction)
    {
    /*TODO: – This method should place a ship on the ocean grid at the starting coordinates, with the
    starting length, and in the specified direction from the starting point. The direction can
    be indicated by 0 = down and 1 = right
    */
    }
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

    int shoot(int row, int column){
        /*– This method should handle a player’s shot at a coordinate on the ocean grid. The return
        value should be as follows:
        ∗ return -1 if the shot misses
        ∗ return 0 if the shot hits
        ∗ return 1 if the shot hits and sinks a ship
        */
    return 0;
    }
    boolean hasBeenAttempted (int row, int column)
    {
    //TODO: –This method returns true if the player has already attempted a shot at the specified coordinates(otherwise false).

        return true;
    }
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
