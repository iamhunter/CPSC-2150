package battleShip;

/**
 * Created by andrewmarionhunter on 9/4/16.
 */
public class Ship {


    String title;
    int shipLength;
    int xShipcoordinate;
    int yShipcoordinate;
    char direction;
    int countDown;


     public  Ship(String title1,
            int length1,
            int xShipcoordinate1,
            int yShipcoordinate1,
            char direction1)
     {
         title = title1;
         shipLength = length1;
         xShipcoordinate = xShipcoordinate1;
         yShipcoordinate = yShipcoordinate1;
         direction = direction1;
         countDown = length1;
     }
}
