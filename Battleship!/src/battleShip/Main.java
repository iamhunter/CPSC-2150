package battleShip;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/4/16.
 */
public class Main {
    public static int shipCounter = 2;
    public static Ship arrayOfships[] = new Ship[10];
    public static int gameBoard[][];

    public static void main (String[] args)
    {
        //callShips(arrayOfships);
        Ship Carrier = new Ship("Carrier",5, 0, 0, 'd');
        Ship Battleship = new Ship("Battleship",4, 1, 0, 'd');

        arrayOfships[0] = Carrier;
        arrayOfships[1] = Battleship;

        gameBoard = buildFirstgameboard(arrayOfships);
        printGameboard(gameBoard);

        System.out.println();
        System.out.println("PLAYER 2 TURN");

        while (shipCounter > 0) {
            takeaShot();
            printGameboard(gameBoard);
        }
        System.out.println("Game Over!");

    }
    public static void takeaShot()
    {
        Scanner in = new Scanner(System.in);


        int xCoordinate, yCoordinate;

        System.out.print("Take a shot: ");

        String line;
        String[] lineVector;

        line = in.nextLine();

        lineVector = line.split(", ");

        xCoordinate = Integer.parseInt(lineVector[0]);
        yCoordinate = Integer.parseInt(lineVector[1]);

        shoot(xCoordinate, yCoordinate, arrayOfships, gameBoard);
    }

    public static void shoot(int x, int y, Ship[] array, int [][] board)
    {
        int counter = 0;
        while(array[counter]!= null)
        {
            if(array[counter].direction == 'r')
            {
                for(int z = 0; z < array[counter].shipLength; z++)
                {
                    if(array[counter].xShipcoordinate == x+z && array[counter].yShipcoordinate == y)
                    {
                        System.out.println("Hit!");
                        return;
                    }
                }
            }
            else if(array[counter].direction == 'd')
            {
                for(int z = 0; z < array[counter].shipLength; z++)
                {
                    if(array[counter].xShipcoordinate == x && (array[counter].yShipcoordinate + z) == y)
                    {
                        System.out.println("Hit!");
                        array[counter].countDown--;
                        if(array[counter].countDown == 0)
                        {
                            System.out.println(array[counter].title + " sunk :(");
                            shipCounter--;
                        }
                        hit(x,y,board);
                        return;
                    }
                }
            }
            counter++;
        }

        System.out.println("Miss!");
        miss(x,y,board);

    }

    public static void miss(int x, int y, int[][] board)

    {
        board[x][y] = 3;
    }

    public static void hit(int x, int y, int[][] board)
    {
        board[x][y] = 2;
    }

    public static void callShips(Ship arrayOfships[])
    {
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
    }

    private static int[][] buildFirstgameboard(Ship[] array)
    {
        Grid grid = new Grid();
        grid.setGridDimensions(10,10);
        int board[][] = grid.gameGrid;


        for(int x = 0; array[x] != null; x++)
        {
             if(!grid.isConflictingShipPlacement(array[x].xShipcoordinate,array[x].yShipcoordinate,array[x].shipLength,array[x].shipLength))
             {
                 break;
             }

        }


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

            if(array[counter].direction == 'r')
            {
                for (int z = 0; z < array[counter].shipLength; z++)
                {
                    if ((x+z) > 9 || (x+z) < 0)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);
                    }
                    else if (y > 9 || y < 0)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);
                    }
                    else if(board[x+z][y] == 1)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);
                    }
                    else
                    {
                        board[x + z][y] = 1;
                    }
                }
            }
            if(array[counter].direction == 'd')
            {
                for(int z = 0; z < array[counter].shipLength; z++)
                {
                    if( x > 9 || x < 0)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);
                    }
                    else if((y+z) > 9 || (y+z) < 0)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);

                    }
                    else if(board[x][y+z] == 1)
                    {
                        System.out.println("Your " + array[counter].title + " was placed illegally. Game Over!");
                        System.exit(1);
                    }
                    else
                    {
                        board[x][y+z] = 1;
                    }
                }

            }
            counter++;
        }
        return board;
    }

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
                if(board[x][y] == 0)
                {
                    System.out.print("- ");
                }
                else if(board[x][y] == 1)
                {
                    System.out.print("@ ");
                }
                else if(board[x][y] == 2)
                {
                    System.out.print("X ");
                }
                else if(board[x][y] == 3)
                {
                    System.out.print("+ ");
                }
                //System.out.print(board[x][y] + " ");
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
