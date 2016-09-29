package cpsc231.divide;

import java.util.Arrays;
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

        int integerDividend = Integer.parseInt(binaryDividend, 2);
        integerDividend = integerDividend << 1;
        binaryDividend = String.format("%16s", Integer.toBinaryString(integerDividend)).replace(' ', '0');

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

        int integerDivisor =  Integer.parseInt(binaryDivisor, 2);

        System.out.println("        - 0 " + binaryDivisor + "         (add 1 11110101)");
        System.out.println("          ----------");
        for(int x = 8; x < 16; x++)
        {
            tempDividendToPrint[x] = null;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < tempDividendToPrint.length/2; i++) {
            strBuilder.append(tempDividendToPrint[i]);
        }

        int accumulator = Integer.parseInt(strBuilder.toString(), 2);

        accumulator = accumulator - integerDivisor;
        String result = Integer.toBinaryString(accumulator);
        result = result.substring(result.length() - 8);

        System.out.println("          "+ 0 + " " + result);




    }
}
