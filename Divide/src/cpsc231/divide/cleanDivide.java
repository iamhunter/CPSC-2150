package cpsc231.divide;

import java.util.Scanner;

/**
 * Created by andrewhunter on 9/29/2016.
 */
public class cleanDivide {
    public static void main(String[] args)
    {
        int decimalDividend = 875;
        int decimalDivisor = 11;
        int carry = 0;
        String binaryDividend;
        String binaryDivisor;
        int accumulator;
        int mq;
        String binaryAcc;
        String binaryMq;
        String[] arrayDividend;
        StringBuilder accBuilder;
        StringBuilder mqBuilder;
        int shiftingDividend;
        String[] tempDividendToPrint;

        Scanner in = new Scanner(System.in);
        System.out.print("enter dividend: ");
        //decimalDividend = in.nextInt();

        System.out.print("enter divisor:");
        //decimalDivisor = in.nextInt();
        System.out.println();

        binaryDividend = String.format("%16s", Integer.toBinaryString(decimalDividend)).replace(' ', '0');
        binaryDivisor = String.format("%8s", Integer.toBinaryString(decimalDivisor)).replace(' ', '0');

        //BEGIN SETTING ACC AND MQ
        arrayDividend = binaryDividend.split("");
        accBuilder = new StringBuilder();
        for (int i = 0; i < arrayDividend.length / 2; i++) {
            accBuilder.append(arrayDividend[i]);
        }
        accumulator = Integer.parseInt(accBuilder.toString(), 2);

        mqBuilder = new StringBuilder();
        for (int i = arrayDividend.length / 2; i < arrayDividend.length; i++) {
            mqBuilder.append(arrayDividend[i]);
        }
        mq = Integer.parseInt(mqBuilder.toString(), 2);

        binaryAcc = String.format("%8s", Integer.toBinaryString(accumulator)).replace(' ', '0');
        binaryMq = String.format("%8s", Integer.toBinaryString(mq)).replace(' ', '0');
        //END SETTING ACC AND MQ

        if(decimalDividend < 1 || decimalDividend > 65535 || decimalDivisor < 1 || decimalDivisor > 255 || decimalDivisor < accumulator)
        {
            System.out.println("Your input is invalid.");
            return;
        }

        //PRINT BEGINNING LINES
        System.out.println("c set to 0");
        System.out.println("acc:mq set to dividend = " + decimalDividend + " decimal and " + binaryDividend + " binary");
        System.out.println("mdr set to divisor = " + decimalDivisor + " decimal and " + binaryDivisor + " binary \n");
        System.out.println("(step 0: ( MDR != 0 ) and ( MDR > ACC ) so no exceptions)");
        System.out.println("---------------------------------------------------");
        //END PRINT BEGINNING LINES

        //BEGIN LOOP
        for(int a = 1; a <= 8; a++)
        {
            System.out.println("step " + a + ":   " + carry + " " + binaryAcc + " " + binaryMq);
            System.out.println("       <<              shift left");

            //BEGIN SHIFTING
            shiftingDividend = Integer.parseInt(binaryDividend, 2);
            shiftingDividend = shiftingDividend << 1;
            binaryDividend = String.format("%16s", Integer.toBinaryString(shiftingDividend)).replace(' ', '0');
            //FINISH SHIFTING

            //BEGIN SETTING ACC AND MQ
            arrayDividend = binaryDividend.split("");
            accBuilder = new StringBuilder();
            for (int i = 0; i < arrayDividend.length / 2; i++) {
                accBuilder.append(arrayDividend[i]);
            }
            accumulator = Integer.parseInt(accBuilder.toString(), 2);

            mqBuilder = new StringBuilder();
            for (int i = arrayDividend.length / 2; i < arrayDividend.length; i++) {
                mqBuilder.append(arrayDividend[i]);
            }
            mq = Integer.parseInt(mqBuilder.toString(), 2);

            binaryAcc = String.format("%8s", Integer.toBinaryString(accumulator)).replace(' ', '0');
            binaryMq = String.format("%8s", Integer.toBinaryString(mq)).replace(' ', '0');
            //END SETTING ACC AND MQ

            //PRINT SHIFTED
            tempDividendToPrint = binaryDividend.split("");
            System.out.print("          " + carry + " " + binaryAcc + " ");
            for (int x = 8; x < 15; x++) {
                System.out.print(tempDividendToPrint[x]);
            }
            System.out.println(".");
            //PRINT SHIFTED

            //PRINT SUBTRACTION LINE
            System.out.println("        - " + carry + " " + binaryDivisor + "         (add 1 11110101)");
            System.out.println("          ----------");
            //END SUBTRACTED LINE

            accumulator = Integer.parseInt(accBuilder.toString(), 2);
            accumulator = accumulator - decimalDivisor;
            binaryAcc = Integer.toBinaryString(accumulator);

            binaryAcc = String.format("%8s", binaryAcc).replace(' ', '0');
            binaryAcc = binaryAcc.substring(binaryAcc.length()-8);

            if(accumulator < 0)
            {
                arrayDividend[15] = "0";

                mqBuilder = new StringBuilder();
                for (int i = arrayDividend.length / 2; i < arrayDividend.length; i++) {
                    mqBuilder.append(arrayDividend[i]);
                }
                mq = Integer.parseInt(mqBuilder.toString(), 2);

                binaryMq = String.format("%8s", Integer.toBinaryString(mq)).replace(' ', '0');
                System.out.println("          1 " + binaryAcc + " " + binaryMq);
                System.out.println("                            ^  set to 0 since subtract unsuccessful");
                System.out.println("        + " + carry + " " + binaryDivisor + "           restoring add");

                accumulator = accumulator + decimalDivisor;
                binaryAcc = Integer.toBinaryString(accumulator);

                binaryAcc = String.format("%8s", binaryAcc).replace(' ', '0');
                binaryAcc = binaryAcc.substring(binaryAcc.length()-8);
                System.out.println("          ----------");
                System.out.println("          " + carry + " " + binaryAcc + " " + binaryMq);
                binaryDividend = binaryAcc + binaryMq;
            }
            else
            {
                arrayDividend[15] = "1";
                mqBuilder = new StringBuilder();
                for (int i = arrayDividend.length / 2; i < arrayDividend.length; i++) {
                    mqBuilder.append(arrayDividend[i]);
                }
                mq = Integer.parseInt(mqBuilder.toString(), 2);

                binaryMq = String.format("%8s", Integer.toBinaryString(mq)).replace(' ', '0');
                System.out.println("          " + carry + " " + binaryAcc + " " + binaryMq);
                System.out.println("                            ^  set to 1 since subtract successful");
                binaryDividend = binaryAcc + binaryMq;
            }
            System.out.println("---------------------------------------------------");
        }
    }
}
