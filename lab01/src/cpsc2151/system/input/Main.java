package cpsc2151.system.input;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 8/24/16.
 */
public class Main {
    public static void main(String[] args) {

        System.out.print("Enter an integer:");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();

        //System.out.print(input);

        String stringInput = String.valueOf(input);


        int counter = 0;

        for(int x = 0; x < 10; counter++)
        {
            String stringCounter = String.valueOf(counter);
            if(stringCounter.contains(stringInput))
            {
                System.out.println(stringCounter);
                x++;
            }

        }

    }

}
