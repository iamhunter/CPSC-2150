package edu.clemson.cpsc2150.project2;

/**
 * Created by andrewmarionhunter on 9/21/16.
 */
public class oldGrid {
    // Default square dimension of the grid
    public static final int DEFAULT_GRID_SIZE = 10;

    // Default number of ships
    public static final int DEFAULT_SHIP_COUNT = 5;

    // Constant values for encoding grid status
    public static final int MISS = 1;
    public static final int HIT = 2;
    public static final int SHIP = 3;

    // Constant values for ship names and lengths
    public static final String[] SHIP_NAMES = { "Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer" };
    public static final int[] SHIP_LENGTHS = { 5, 4, 3, 3, 2 };

    // Constant values for encoding directions
    public static final int UNKNOWN = -1;
    public static final int DOWN = 0;
    public static final int RIGHT = 1;

    // Constant values for encoding shot result
    public static final int SHOT_MISS = -1;
    public static final int SHOT_HIT = 0;
    public static final int SHOT_SUNK = 1;

    private int myRowCount, myColCount;
    private int[][] myStatusGrid;
    private int[][] myShipGrid;
    private int[] myShipHitsRemaining;
    private int myTotalHitsRemaining;

    private int myShipToBePlaced;
    private int myLastSunkShip;

    public void setGridDimensions (int rows, int cols) {
        myRowCount = rows;
        myColCount = cols;

        myStatusGrid = new int[myRowCount][myColCount];
        myShipGrid = new int[myRowCount][myColCount];
        myShipHitsRemaining = new int[DEFAULT_SHIP_COUNT];
        myTotalHitsRemaining = 0;
    }

    public void placeShip (int row, int col, int len, int dir) {
        // set the remaining number of hits for this ship
        myShipHitsRemaining[myShipToBePlaced] = len;
        myTotalHitsRemaining += len;

        // loop through each coordinate of the ship to be placed
        for (int i = 0; i < len; ++i) {
            // set the status and ship at current coordinates
            myStatusGrid[row][col] = SHIP;
            myShipGrid[row][col] = myShipToBePlaced;

            // increment the ship coordinates
            if (dir == DOWN) {
                ++row;
            } else {
                ++col;
            }
        }
    }

    public boolean isConflictingShipPlacement (int row, int col, int len, int dir) {
        // loop through each coordinate of the ship to be placed
        for (int i = 0; i < len; ++i) {

            // does the ship go off the grid?
            if (row < 0 || col < 0 || row >= myRowCount || col >= myColCount) {
                return true;
            }

            // does the ship overlap with another ship?
            if (myStatusGrid[row][col] == SHIP) {
                return true;
            }

            // increment the ship coordinates
            if (dir == DOWN) {
                ++row;
            } else {
                ++col;
            }
        }
        return false;
    }

    public int shoot(int row, int col) {
        // is it a hit?
        if (myStatusGrid[row][col] == SHIP) {
            // change status to hit
            myStatusGrid[row][col] = HIT;

            // decrement the remaining number of hits
            int ship = myShipGrid[row][col];
            --myShipHitsRemaining[ship];
            --myTotalHitsRemaining;

            // is the ship sunk?
            if (myShipHitsRemaining[ship] == 0) {
                // the ship is sunk!
                myLastSunkShip = ship;
                return SHOT_SUNK;
            } else {
                // the ship is hit, but not sunk
                return SHOT_HIT;
            }
        } else {
            // change status to miss
            myStatusGrid[row][col] = MISS;
            return SHOT_MISS;
        }
    }

    public boolean hasBeenAttempted (int row, int col) {
        return (myStatusGrid[row][col] == MISS || myStatusGrid[row][col] == HIT);
    }

    public void displayGrid(boolean showShips) {
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

    public void setShipToBePlaced(int ship) {
        myShipToBePlaced = ship;
    }

    public int getLastSunkShip() {
        return myLastSunkShip;
    }

    public boolean isGameOver() {
        return (myTotalHitsRemaining == 0);
    }
}
