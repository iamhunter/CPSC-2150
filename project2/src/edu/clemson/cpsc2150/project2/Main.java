package edu.clemson.cpsc2150.project2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /****** UNCOMMENT THE METHOD FOR THE VERSION THAT YOU WANT TO RUN ******/

        //run85PctVersion();
        run100PctVersion();
    }

    public static void run85PctVersion() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // create the grid
        Grid grid = new Grid();
        grid.setGridDimensions(Grid.DEFAULT_GRID_SIZE, Grid.DEFAULT_GRID_SIZE);

        // place the ships
        System.out.println("PLAYER 1 TURN");
        for (int ship = 0; ship < Grid.DEFAULT_SHIP_COUNT; ++ship) {
            boolean shipPlaced = false;
            do {
                // read in the coordinates
                System.out.printf("Place your %s: ", Grid.SHIP_NAMES[ship]);
                int[] coords = parseCoordinates(reader.readLine());

                // read in the direction
                System.out.print("Choose direction (d/r): ");
                int dir = parseDirection(reader.readLine());

                // can we place the ship here?
                if (dir != Grid.UNKNOWN && !grid.isConflictingShipPlacement(coords[0], coords[1], Grid.SHIP_LENGTHS[ship], dir)) {
                    // place the ship!
                    grid.setShipToBePlaced(ship);
                    grid.placeShip(coords[0], coords[1], Grid.SHIP_LENGTHS[ship], dir);
                    shipPlaced = true;
                } else {
                    // print error message
                    System.out.println("Unable to place ship at that location! Please try again.");
                }
            } while (!shipPlaced);
        }

        // take shots at the grid
        System.out.println("\nPLAYER 2 TURN");
        int numShots = 0;

        // loop until the game is over
        while (!grid.isGameOver()) {
            // get the coordinates for the next shot
            boolean isValidShot = false;
            int[] coords;
            do {
                System.out.print("Take a shot: ");
                coords = parseCoordinates(reader.readLine());

                // has a shot at this location already been attempted?
                if (grid.hasBeenAttempted(coords[0], coords[1])) {
                    System.out.println("You have already shot at that location! Please try again.");
                } else {
                    isValidShot = true;
                }
            } while (!isValidShot);

            // take the shot
            int result = grid.shoot(coords[0], coords[1]);
            ++numShots;

            // display the result of the shot
            switch (result) {
                case Grid.SHOT_MISS:
                    System.out.println("Miss!");
                    break;
                case Grid.SHOT_HIT:
                    System.out.println("Hit!");
                    break;
                case Grid.SHOT_SUNK:
                    int ship = grid.getLastSunkShip();
                    System.out.printf("Hit!\nSunk the %s!\n", Grid.SHIP_NAMES[ship]);
                    break;
            }
        }

        // game over!
        System.out.printf("\nGame over! You won in %d shots!\n", numShots);
    }

    public static void run100PctVersion() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // setup the grid for each player
        Grid[] grids = new Grid[2];
        for (int player = 0; player < 2; ++player) {
            // create the grid
            grids[player] = new Grid();
            grids[player].setGridDimensions(Grid.DEFAULT_GRID_SIZE, Grid.DEFAULT_GRID_SIZE);

            // place the ships
            System.out.printf("PLAYER %d TURN\n", player + 1);

            for (int ship = 0; ship < Grid.DEFAULT_SHIP_COUNT; ++ship) {
                boolean shipPlaced = false;
                do {
                    // display the grid
                    grids[player].displayGrid(true);

                    // read in the coordinates
                    System.out.printf("\nPlace your %s: ", Grid.SHIP_NAMES[ship]);
                    int[] coords = parseCoordinates(reader.readLine());

                    // read in the direction
                    System.out.print("Choose direction (d/r): ");
                    int dir = parseDirection(reader.readLine());

                    // can we place the ship here?
                    if (dir != Grid.UNKNOWN && !grids[player].isConflictingShipPlacement(coords[0], coords[1], Grid.SHIP_LENGTHS[ship], dir)) {
                        // place the ship!
                        grids[player].setShipToBePlaced(ship);
                        grids[player].placeShip(coords[0], coords[1], Grid.SHIP_LENGTHS[ship], dir);
                        shipPlaced = true;
                    } else {
                        // print error message
                        System.out.println("Unable to place ship at that location! Please try again.");
                    }
                } while (!shipPlaced);
            }
        }

        // loop until the game is over
        int player = 0, opponent = 1;
        while (!grids[0].isGameOver() && !grids[1].isGameOver()) {
            // display player turn
            System.out.printf("\nPLAYER %d TURN\n", player + 1);
            grids[opponent].displayGrid(false);

            // get the coordinates for the next shot
            boolean isValidShot = false;
            int[] coords;
            do {
                System.out.print("Take a shot: ");
                coords = parseCoordinates(reader.readLine());

                // has a shot at this location already been attempted?
                if (grids[opponent].hasBeenAttempted(coords[0], coords[1])) {
                    System.out.println("You have already shot at that location! Please try again.");
                } else {
                    isValidShot = true;
                }
            } while (!isValidShot);

            // take the shot at the opponent's grid
            int result = grids[opponent].shoot(coords[0], coords[1]);

            // display the result of the shot
            switch (result) {
                case Grid.SHOT_MISS:
                    System.out.println("Miss!");
                    break;
                case Grid.SHOT_HIT:
                    System.out.println("Hit!");
                    break;
                case Grid.SHOT_SUNK:
                    int ship = grids[opponent].getLastSunkShip();
                    System.out.printf("Hit!\nSunk the %s!\n", Grid.SHIP_NAMES[ship]);
                    break;
            }

            // switch players!
            player = (player + 1) % 2;
            opponent = (opponent + 1) % 2;
        }

        // game is over... determine who the winner is
        int winner;
        if (grids[1].isGameOver()) {
            winner = 1;
        } else {
            winner = 2;
        }

        System.out.printf("\nGame over! Player %d wins!\n", winner);
    }

    public static int[] parseCoordinates(String input) {
        // initialize coordinate array
        int[] coords = new int[2];

        // split the input string into tokens
        String[] tokens = input.split("\\D+");

        // parse each token as an integer
        coords[0] = Integer.parseInt(tokens[0]);
        coords[1] = Integer.parseInt(tokens[1]);
        return coords;
    }

    public static int parseDirection(String input) {
        if (input.toLowerCase().equals("d")) {
            return Grid.DOWN;
        } else if (input.toLowerCase().equals("r")) {
            return Grid.RIGHT;
        } else {
            return Grid.UNKNOWN;
        }
    }
}
