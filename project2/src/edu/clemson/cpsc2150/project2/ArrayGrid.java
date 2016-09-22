package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class ArrayGrid implements Grid {

    private int myRowCount, myColCount;
    private int[][] myStatusGrid;
    private int[][] myShipGrid;
    private int[] myShipHitsRemaining;
    private int myTotalHitsRemaining;

    private int myShipToBePlaced;
    private int myLastSunkShip;


    public void setGridDimensions(int rows, int cols)
    {
        myRowCount = rows;
        myColCount = cols;

        myStatusGrid = new int[myRowCount][myColCount];
        myShipGrid = new int[myRowCount][myColCount];
        myShipHitsRemaining = new int[DEFAULT_SHIP_COUNT];
        myTotalHitsRemaining = 0;
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
        ShipImpl potato = new ShipImpl(ShipType.CARRIER);
        Coordinate x = new Coordinate();
        x.row = 3;
        x.col = 4;

        return potato;
    }

    public boolean hasBeenAttempted(Coordinate coord)
    {
        //If has been attempted
        return true;
    }

    public void displayGrid(boolean showShips)
    {
        System.out.println();
        for (int i = -1; i < myRowCount; ++i) {
            if (i == -1) {
                System.out.print("   ");
                for (int j = 0; j < myColCount; ++j) {
                    System.out.printf("%4d", j);
                }
                System.out.println();
            } else {
                System.out.print("\n  " + i);
                for (int j = 0; j < myColCount; ++j) {
                    System.out.printf("%4s", getGridChar(i, j, showShips));
                }
                System.out.println();
            }
        }
    }

    private String getGridChar(int row, int col, boolean showShips) {
        switch(myStatusGrid[row][col]) {
            case MISS:
                return "+";
            case HIT:
                return "X";
            case SHIP:
                if (showShips) {
                    return "@";
                } else {
                    return "-";
                }
            default:
                return "-";
        }
    }

    // returns true if all ships have been sunk
    // otherwise, false
    public boolean isGameOver()
    {
        return true;
    }
}
