
/**
 * Departure class contains the relevant information to a departure event
 *
 * @author Omar Drira
 * @version 04/04/20
 */
public class Departure extends Event implements Comparable<Event>
{
    
    /**
     * Constructor for objects of class Departure
     */
    public Departure(Customer c,int time){
        who=c;
        this.time=time;
        type=2;
    }
    
    /**
     * process method processes a departure event and returns a null
     * @return null
     */
    public Departure process(){
        return null;
    }
    
}
