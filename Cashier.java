import java.util.*;
/**
 * Cashier class contains cashier information
 *
 * @author Omar Drira
 * @version 04/04/20
 */
public class Cashier
{
    int serveTime;
    float profit;
    boolean available =true;
    Random r;
    /**
     * Constructor for objects of class Cashier
     */
    public Cashier()
    {
       
    }
    
    /**
     * assign method is called everytime a customer is assigned to a cashier and generates a random serveTime and a random profit
     * @param lower bound for the serving time
     * @param upper bound for the serving time
     * @param lower bound for the profit
     * @param upper bound for the profit
     */
    public Cashier assign(int t1, int t2, float p1, float p2){
        r = new Random();
        serveTime = t1+ r.nextInt(t2-t1);
        profit =p1 + r.nextInt((int)(p2-p1)) + r.nextFloat();
        return this;
    }

    /**
     * notAvailable method changes the value of the boolean variable available to false
     */
    public void notAvailable()
    {
        available=false;
    }
    
    /**
     * getAvailable returns a boolean describing if the cashier is available or not
     * @return a boolean describing if the cashier is available or not
     */
    public boolean getAvailable(){
    return available;}
}
