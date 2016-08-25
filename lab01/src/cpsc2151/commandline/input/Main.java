package cpsc2151.commandline.input;

/**
 * Created by andrewmarionhunter on 8/24/16.
 */
public class Main {
    public static void main(String[] args){
        int sum = 0;
        for(int i = 0; i < args.length; i++)
        {
            //System.out.print(args[i]);
            sum = sum + Integer.parseInt(args[i]);

        }
        System.out.print(sum);
    }
}