package cpsc2151.arrays;
import java.util.Scanner;


/**
 * Created by andrewmarionhunter on 8/31/16.
 */

public class Main {
    public static void main(String[] args)
    {

        int[] testArray = new int[5];

        System.out.print("Enter an integer array: ");

        Scanner scanner = new Scanner(System.in);


        for(int x = 0; x < 5; x ++)
        {
            testArray[x] = scanner.nextInt();
        }

        System.out.print("Enter an  integer value: ");

        int testNumber = scanner.nextInt();

        isInArray(testNumber, testArray);

    }


    /**
     * @param toFind Value to find.
     * @param toSearch Array to search.
     * @return Indicator of value presence in the array.
     * @requires
     * toSearch != null
     * @ensures <pre>
     * [The contents of toSearch are unchanged.] and
     * [The return is true if toFind was found in toSearch; otherwise
     * the return is false.]
     * </pre>
     */

    private static boolean isInArray(int toFind, int[] toSearch)
    {

        for(int x = 0; x < toSearch.length; x++)
        {
            if(toFind == toSearch[x])
            {
                System.out.print("Success! The value " + toFind + " is present in the array.");
                return true;
            }
        }
        System.out.print("Failure! The value " + toFind +" is not present in the array.");
        return false;
    }
}


