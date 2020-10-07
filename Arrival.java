
/**
 * Arrival class contains the relevant information to an arrival event
 *
 * @author Omar Drira
 * @version 04/04/20
 */
public class Arrival extends Event implements Comparable<Event>
{
    
    
    /**
     * Constructor for objects of class Arrival
     */
    public Arrival()
    {
        this(null,0);
    }
    /**
     * Constructor for objects of class Arrival
     */
    public Arrival(Customer c,int time){
        who=c;
        this.time=time;
        type=1;
    }
    /**
     * process method processes an arrival and returns a departure
     * @return a departure event resulting from the processing of the arrival event
     */
    public Departure process(){
        Departure d = new Departure(who,time + who.cashier.serveTime);
        return d;
    }
    
}
