package battleShip;

/**
 * Created by andrewmarionhunter on 9/7/16.
 */
public class Grid {
    void setGridDimensions (int rows, int columns)
    {
    //TODO: – This method should create and initialize the ocean grid using the specified dimensions.
    Grid gameGrid[][] = new Grid[rows][columns];
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
    /*TODO: – This method uses the same parameters of the previous method and returns true if either
    of the following conditions are met (otherwise false):
    ∗ the ship overlaps a previously placed ship
    ∗ the ship goes outside the dimensions of the grid
    • int shoot(int row, int column)
    – This method should handle a player’s shot at a coordinate on the ocean grid. The return
    value should be as follows:
    ∗ return -1 if the shot misses
    ∗ return 0 if the shot hits
    ∗ return 1 if the shot hits and sinks a ship
    • boolean hasBeenAttempted (int row, int column)
    – This method returns true if the player has already attempted a shot at the specified
    coordinates (otherwise false).
    • void displayGrid(boolean showShips)
    – This method prints the grid to standard output. The format of the grid is demonstrated
    in the sample output at the end of these instructions. If the parameter is true, display
    the placement of the ships; otherwise, only display the hits and misses.
    */
    return true;
    }

}
