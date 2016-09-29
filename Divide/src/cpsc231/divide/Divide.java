package cpsc231.divide;

import java.util.Scanner;

/**
 * Created by andrewmarionhunter on 9/28/16.
 */
public class Divide {
    public static void main(String[]args)
    {
        int decimalDividend;
        int decimalDivisor;

        String binaryDividend;
        String binaryDivisor;

        Scanner in = new Scanner(System.in);
        System.out.print("enter dividend: ");
        decimalDividend = in.nextInt();


        System.out.print("enter divisor:");
        decimalDivisor = in.nextInt();
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
        System.out.print("       <<              shift left");

        int integerString = Integer.parseInt(binaryDividend);
        integerString<<1;

    }

    private static void printBinary(int toBinary)
    {
        int remainder;

        if(toBinary <=1)
        {
            System.out.print(toBinary);
            return;
        }

        remainder = toBinary %2;
        printBinary(toBinary >> 1);
        System.out.print(remainder);
    }
}
