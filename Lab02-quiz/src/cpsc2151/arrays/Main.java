package cpsc2151.arrays;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by andrewmarionhunter on 8/31/16.
 */
public class Main {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer array: ");
        String line = scanner.nextLine();
        StringTokenizer lineTokens = new StringTokenizer(line);

        int[] array = new int[lineTokens.countTokens()];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(lineTokens.nextToken());
        }

        System.out.print("Enter an integer value: ");

        int value = scanner.nextInt();
        scanner.close();

        alterArray(array, value);

        System.out.print("Altered array: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }



    }

    /**
     * @param toAlter Array to alter.
     * @param alteration Value to alter the array with.
     * @requires
     * toAlter != null
     * @ensures <pre>
     * [Each entry of toAlter is divided by alteration, using truncation.]
     * </pre>
     */

    private static void alterArray(int[] toAlter, int alteration)
    {
            for(int i = 0; i < toAlter.length; i++)
            {
                toAlter[i] = toAlter[i]/alteration;
            }

    }
}
