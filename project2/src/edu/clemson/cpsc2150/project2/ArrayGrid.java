package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class ArrayGrid implements Grid {
    public void setGridDimensions(int rows, int cols)
    {

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
        Ship[] potato = new Ship[0];
        return potato[0];
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
}
