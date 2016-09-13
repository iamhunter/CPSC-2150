package battleShip;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/4/16.
 */
public class Main {
    //List of static variables to be used throughout the program
    public static int shipCounter1 = 1;
    public static Ship arrayOfships1[] = new Ship[10];
    public static int gameBoard1[][];
    public static int shipCounter2 = 1;
    public static Ship arrayOfships2[] = new Ship[10];
    public static int gameBoard2[][];
    public static int roundCounter = 0;

    //main function runs through the program
    public static void main (String[] args) {

        System.out.println("PLAYER 1 TURN");
        callShips(arrayOfships1);

        System.out.println("PLAYER 2 TURN");
        callShips(arrayOfships2);

        System.out.println();


        gameBoard2 = buildFirstgameboard(arrayOfships2);
        gameBoard1 = buildFirstgameboard(arrayOfships1);

        while (shipCounter1 > 0 & shipCounter2 > 0) {
            printInGameboard(gameBoard2);
            System.out.println("PLAYER 1 TURN");
            takeaShotat(2);

            printInGameboard(gameBoard1);
            System.out.println("PLAYER 2 TURN");
            takeaShotat(1);

            roundCounter++;
        }

        if (shipCounter1 == 0)
        {
            System.out.println("Player 2 Wins in " + roundCounter + " shots!");
        }

        else if (shipCounter2 == 0)
        {
            System.out.print("Player 1 Wins in " + roundCounter + " shots!");
        }


        System.out.println("Game Over!");

    }
    /**
     * @return void
     * @requires
     * variable != null
     * xCoordinate & yCoordinate != null
     * xCoordinate & yCoordinate > -1
     * [xCoordinate & yCoordinate have not been used yet]
     * @ensures <pre>
     * [Shoots at the proper spot on the proper board]
     * </pre>
     */
    public static void takeaShotat(int variable)
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

        if(variable == 1)
        {
            shoot(xCoordinate, yCoordinate, arrayOfships1, gameBoard1, variable);
        }
        else if(variable == 2)
        {
            shoot(xCoordinate, yCoordinate, arrayOfships2, gameBoard2, variable);

        }
    }

    public static void shoot(int x, int y, Ship[] array, int [][] board, int variable)
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
                        if(board[x+z][y] == 2)
                        {
                            System.out.println("Your have already shot there! Lose a turn.");
                            return;
                        }
                        array[counter].countDown--;
                        if(array[counter].countDown == 0)
                        {
                            System.out.println(array[counter].title + " sunk :(");
                            if(variable == 1) {
                                shipCounter1--;
                            }
                            else if(variable == 2)
                            {
                                shipCounter2--;
                            }
                        }
                        hit(x,y,board);
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
                        if(board[x][y+z] == 2)
                        {
                            System.out.println("Your have already shot there! Lose a turn.");
                            return;
                        }
                        array[counter].countDown--;
                        if(array[counter].countDown == 0)
                        {

                            System.out.println(array[counter].title + " sunk :(");
                            if(variable ==1) {
                                shipCounter1--;
                            }
                            else if(variable == 2)
                            {
                                shipCounter2--;
                            }
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

    /**
     * @return void
     * @requires
     * arrayOfships != null
     * xCoordinate & yCoordinate != null
     * xCoordinate & yCoordinate > -1
     * [xCoordinate & yCoordinate have not been used yet]
     * @ensures <pre>
     * [Ships are created and placed on the board properly]
     * </pre>
     */
    public static void callShips(Ship arrayOfships[])
    {
        int board[][] = buildFirstgameboard(arrayOfships);
        printGameboard(board);

        System.out.println();
        System.out.print("Place your Carrier(length 5): ");

        Scanner in = new Scanner(System.in);
        int xCoordinate, yCoordinate;
        char direction;

        String line;
        String[] lineVector;

        line = in.nextLine();

        lineVector = line.split(", ");

        yCoordinate = Integer.parseInt(lineVector[0]);
        xCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Carrier = new Ship("Carrier",5, xCoordinate, yCoordinate, direction);

        arrayOfships[0] = Carrier;

        board = buildFirstgameboard(arrayOfships);
        printGameboard(board);

        in = new Scanner(System.in);
        System.out.print("Place your Battleship(length 4): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        yCoordinate = Integer.parseInt(lineVector[0]);
        xCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Battleship = new Ship("Battleship",4, xCoordinate, yCoordinate, direction);

        arrayOfships[1] = Battleship;

        board = buildFirstgameboard(arrayOfships);
        printGameboard(board);

        in = new Scanner(System.in);
        System.out.print("Place your Cruiser(length 3): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        yCoordinate = Integer.parseInt(lineVector[0]);
        xCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Cruiser = new Ship("Cruiser",3, xCoordinate, yCoordinate, direction);

        arrayOfships[2] = Cruiser;

        board = buildFirstgameboard(arrayOfships);
        printGameboard(board);

        in = new Scanner(System.in);
        System.out.print("Place your Submarine(length 3): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        yCoordinate = Integer.parseInt(lineVector[0]);
        xCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Submarine = new Ship("Submarine",3, xCoordinate, yCoordinate, direction);

        arrayOfships[3] = Submarine;

        board = buildFirstgameboard(arrayOfships);
        printGameboard(board);

        in = new Scanner(System.in);
        System.out.print("Place your Destroyer(length 2): ");

        line = in.nextLine();

        lineVector = line.split(", ");

        yCoordinate = Integer.parseInt(lineVector[0]);
        xCoordinate = Integer.parseInt(lineVector[1]);

        System.out.print("Choose direction (d/r): ");
        direction = in.next().charAt(0);

        Ship Destroyer = new Ship("Destroyer",2, xCoordinate, yCoordinate, direction);

        arrayOfships[4] = Destroyer;
        board = buildFirstgameboard(arrayOfships);
        printGameboard(board);
    }

    /**
     * @return Gameboard
     * @requires
     * array != null
     * [Proper ships to be placed on the board]
     * @ensures <pre>
     * [Gameboard is built properly]
     * </pre>
     */
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

    /**
     * @return void
     * @requires
     * board != null
     * [Proper gameboard]
     * @ensures <pre>
     * [Gameboard is printed properly]
     * </pre>
     */
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

    /**
     * @return void
     * @requires
     * board != null
     * [Proper gameboard]
     * @ensures <pre>
     * [Gameboard is printed properly]
     * </pre>
     */
    private static void printInGameboard(int[][] board)
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
                    System.out.print("- ");
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
}
