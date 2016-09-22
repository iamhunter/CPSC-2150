package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/20/16.
 */

public interface Ship {
    // sets the placement of this ship starting at
    // coordinate "coordZ" and proceeding in direction "dir"
    void setCoordinates(Coordinate coord, Direction dir);

    // returns an array of the ship's coordinates
    Coordinate[] getCoordinates();

    // returns the type of the ship
    ShipType getType();

    // takes a shot at this ship's coordinates and
    // returns Status.MISS, Status.HIT, or STATUS.SUNK
    Status shoot(Coordinate coord);

    // returns true if all of the ship's corrdinates are hit
    // but otherwise, false
    boolean isSunk();
}
