package cpsc231.divide;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/28/16.
 */
public class Divide {
    public static void main(String[]args)
    {
        int decimalDividend = 875;
        int decimalDivisor = 11;

        String binaryDividend;
        String binaryDivisor;

        Scanner in = new Scanner(System.in);
        System.out.print("enter dividend: ");
        //decimalDividend = in.nextInt();


        System.out.print("enter divisor:");
        //decimalDivisor = in.nextInt();
        System.out.println();

        binaryDividend = String.format("%16s", Integer.toBinaryString(decimalDividend)).replace(' ', '0');
        binaryDivisor = String.format("%8s", Integer.toBinaryString(decimalDivisor)).replace(' ', '0');

        System.out.println("c set to 0");
        System.out.println("acc:mq set to dividend = " + decimalDividend + " decimal and " + binaryDividend + " binary");
        System.out.println("mdr set to divisor = " + decimalDivisor + " decimal and " + binaryDivisor + " binary \n");
        System.out.println("(step 0: ( MDR != 0 ) and ( MDR > ACC ) so no exceptions)");
        System.out.println("---------------------------------------------------");

        String[] tempDividendToPrint = binaryDividend.split("");

        System.out.print("step 1:   0 ");
        for(int x = 0; x < 8; x++)
        {
            System.out.print(tempDividendToPrint[x]);
        }
        System.out.print(" ");
        for(int x = 8; x < 16; x++)
        {
            System.out.print(tempDividendToPrint[x]);
        }

        System.out.println();
        System.out.println("       <<              shift left");

        int integerString = Integer.parseInt(binaryDividend, 2);
        integerString = integerString << 1;
        binaryDividend = String.format("%16s", Integer.toBinaryString(integerString)).replace(' ', '0');
        tempDividendToPrint = binaryDividend.split("");
        System.out.print("          0 ");
        for(int x = 0; x < 8; x++)
        {
            System.out.print(tempDividendToPrint[x]);
        }
        System.out.print(" ");
        for(int x = 8; x < 15; x++)
        {
            System.out.print(tempDividendToPrint[x]);
        }
        System.out.println(".");

        //TODO: Don't hardcode the add function
        System.out.println("        - 0 " + binaryDivisor + "         (add 1 11110101)");
        System.out.println("          ----------");



    }
}
