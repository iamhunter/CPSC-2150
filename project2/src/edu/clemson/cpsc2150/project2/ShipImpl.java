package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/20/16.
 */
public class ShipImpl implements Ship{


    private int length;
    private String name;

    ShipImpl(ShipType ship)
    {
        //Sets the length
        length = ship.length;
        name = ship.name;
    }

    public void setCoordinates(Coordinate coord, Direction dir)
    {

    }

    // returns an array of the ship's coordinates
    public Coordinate[] getCoordinates()
    {
        Coordinate array[] = new Coordinate[3];

        return array;
    }

    // returns the type of the ship
    public ShipType getType()
    {
        return ShipType.CARRIER;
    }


    // takes a shot at this ship's coordinates and
    // returns Status.MISS, Status.HIT, or STATUS.SUNK
    public Status shoot(Coordinate coord)
    {
        //If hit
        return Status.HIT;
    }

    // returns true if all of the ship's corrdinates are hit
    // but otherwise, false
    public boolean isSunk()
    {
        //If all ships coordinates are hit
        return true;

        // Else
        // return false
    }

    public int getLength()
    {
        return length;
    }

}
