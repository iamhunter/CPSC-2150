package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/20/16.
 */
public class ShipImpl implements Ship{


    private int length;
    private String name;
    private Direction direction;
    private Coordinate[] coordArray;
    private ShipType type;

    ShipImpl(ShipType ship)
    {
        //Sets the length
        length = ship.length;
        name = ship.name;
        type = ship;
    }

    public void setCoordinates(Coordinate coord, Direction dir)
    {
        direction = dir;
        coordArray = new Coordinate[length];
        for (int i = 0; i < length; i++)
        {
            if (direction == Direction.DOWN)
            {
                coordArray[i] = coord;
                //coordArray[i].row = coord.row;
            }
            else if (direction == Direction.RIGHT)
            {
                coordArray[i] = coord;
                //coordArray[i].row = coord.row + i;
            }
        }

    }

    // returns an array of the ship's coordinates
    public Coordinate[] getCoordinates()
    {
        return coordArray;
    }

    public String getName()
    {
        return name;
    }

    // returns the type of the ship
    public ShipType getType()
    {
        return type;
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

    public Direction getDirection()
    {
        return direction;
    }
}
