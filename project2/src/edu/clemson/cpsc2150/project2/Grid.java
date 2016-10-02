package edu.clemson.cpsc2150.project2;

public interface Grid
{
    // Default square dimension of the grid
    int DEFAULT_GRID_SIZE = 10;

    // Default number of ships
    int DEFAULT_SHIP_COUNT = 5;

    // Constant values for encoding grid status
    int MISS = 1;
    int HIT = 2;
    int SHIP = 3;

    // Constant values for ship names and lengths
    String[] SHIP_NAMES ={ShipType.CARRIER.name, ShipType.BATTLESHIP.name, ShipType.CRUISER.name, ShipType.SUBMARINE.name, ShipType.DESTROYER.name};
    int[] SHIP_LENGTHS = {ShipType.CARRIER.length, ShipType.BATTLESHIP.length, ShipType.CRUISER.length, ShipType.SUBMARINE.length, ShipType.DESTROYER.length};
    ShipType[] SHIP_STUFF ={ShipType.CARRIER, ShipType.BATTLESHIP, ShipType.CRUISER, ShipType.SUBMARINE, ShipType.DESTROYER};


    // Constant values for encoding directions
    int UNKNOWN = -1;
    int DOWN = 0;
    int RIGHT = 1;

    void setGridDimensions(int rows, int cols);


    void placeShip(Ship ship);

    boolean isConflictingShipPlacement (Ship ship);


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