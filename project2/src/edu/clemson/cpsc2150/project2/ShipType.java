package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/20/16.
 */
public enum ShipType {
    CARRIER("Carrier", 5),
    BATTLESHIP("Battleship", 4),
    CRUISER("Cruiser", 3),
    SUBMARINE("Submarine", 3),
    DESTROYER("Destroyer", 2);

    String name;
    int length;

    ShipType(String theName, int theLength)
    {
        name = theName;
        length = theLength;
    }
}
