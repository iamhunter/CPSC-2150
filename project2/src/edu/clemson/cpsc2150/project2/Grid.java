package edu.clemson.cpsc2150.project2;

public interface Grid
{
    void setGridDimensions(int rows, int cols);

    void placeShip(Ship ship);

    // see Ship.shoot()
    Status shoot(Coordinate coord);

    // returns Ship object representing the last ship
    // which was sunk(null if no ship has been sunk)
    Ship getLastSunkShip();

    boolean hasBeenAttempted(Coordinate coord);

    void displayGrid(boolean showShips);

    // returns true if all ships have been sunk
    // otherwise, false
    boolean isGameOver();

}