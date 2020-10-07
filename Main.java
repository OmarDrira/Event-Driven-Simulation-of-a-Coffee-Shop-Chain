import java.util.*;
import java.io.FileReader;
/**
 * Main class is used for testing the project
 *
 * @author Omar Drira
 * @version 04/20/20
 */
public class Main
{
    Scanner sc;
    int s;
    Simulation si;
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {

    }
    /**
     * main method is used to test the project for correctness
     * @param String array of arguments
     */
    public static void main(String[] args)
    {   
        Main m= new Main();
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Type the number of cashiers: ");
            m.s= sc.nextInt();
        } catch (Exception e){System.out.println("exception occured");}
        m.si = new Simulation(m.s);
        m.si.runSimulation();
        System.out.println("overflow rate: "+ m.si.overflow+" / "+m.si.n);
        System.out.println("net profit: "+ m.si.totalProfit);
        System.out.println("average waitime: "+m.si.average+"seconds, max waitime: "+m.si.max+" seconds");
    }
}
