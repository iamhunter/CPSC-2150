package battleShip;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/4/16.
 */
public class Main {
    public static void main (String[] args)
    {
        printEmptygameboard();

        System.out.println("PLAYER 1 TURN");
        System.out.println();
        System.out.print("Place your Carrier(length 5): ");

        Scanner in = new Scanner(System.in);
        int xCoordinate, yCoordinate;
        char direction;

        String line;
        String[] lineVector;

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Carrier = new Ship("Carrier",5, xCoordinate, yCoordinate, direction);

        Ship arrayOfships[] = new Ship[10];
        arrayOfships[0] = Carrier;


        in = new Scanner(System.in);
        System.out.print("Place your Battleship(length 4): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Battleship = new Ship("Battleship",4, xCoordinate, yCoordinate, direction);

        arrayOfships[1] = Battleship;


        in = new Scanner(System.in);
        System.out.print("Place your Cruiser(length 3): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Cruiser = new Ship("Cruiser",3, xCoordinate, yCoordinate, direction);

        arrayOfships[2] = Cruiser;


        in = new Scanner(System.in);
        System.out.print("Place your Submarine(length 3): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Submarine = new Ship("Submarine",3, xCoordinate, yCoordinate, direction);

        arrayOfships[3] = Submarine;


        in = new Scanner(System.in);
        System.out.print("Place your Destroyer(length 2): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Destroyer = new Ship("Destroyer",2, xCoordinate, yCoordinate, direction);

        arrayOfships[4] = Destroyer;


        int gameBoard[][];

        gameBoard = buildFirstgameboard(arrayOfships);
        printGameboard(gameBoard);

        System.out.println();
        System.out.println("PLAYER 2 TURN");


        for(int x = 0; x < 3; x++)
        {
            System.out.println("Take a shot: ");



        }
    }

    private static int[][] buildFirstgameboard(Ship[] array )
    {
        int board[][] = new int[10][10];

        //Initialize array to 0
        for(int x = 0; x < 10; x++)
        {
            for(int y = 0; y < 10; y++)
            {
                board[x][y] = 0;
            }
        }

        //Change spots with ships to 1
        int counter = 0;
        while(array[counter] != null)
        {
            int x, y;
            x = array[counter].xShipcoordinate;
            y = array[counter].yShipcoordinate;
            board[x][y] = 1;

            if(array[counter].direction == 'r')
            {
                for(int z = 1; z < array[counter].length; z++)
                {
                    board[x+z][y] = 1;
                }
            }
            if(array[counter].direction == 'd')
            {
                for(int z = 1; z < array[counter].length; z++)
                {
                    board[x][y+z] = 1;
                }
            }
            counter++;
        }
        return board;
    }

    //TODO: Change numbers to characters
    private static void printGameboard(int[][] board)
    {
        //Print top numbers
        System.out.print("  ");
        for (int y  = 0; y < 10; y++)
        {
            System.out.print(y + " ");
        }
        System.out.println();

        //Print game board
        for (int y = 0; y < 10; y++)
        {
            //Print side numbers
            System.out.print(y + " ");

            for(int x = 0; x < 10; x ++)
            {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printEmptygameboard()
    {
        //Print top numbers
        System.out.print("  ");
        for (int x  = 0; x < 10; x++)
        {
            System.out.print(x + " ");
        }
        System.out.println();

        //Print game board
        for (int x = 0; x < 10; x++)
        {
            //Print side numbers
            System.out.print(x + " ");
            for(int y = 0; y < 10; y ++)
            {
                System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
