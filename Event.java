
/**
 * Abstract Event class is an abstract class for an event
 *
 * @author Omar Drira
 * @version 04/04/20
 */
public abstract class Event implements Comparable<Event>
{
    Customer who;
    int time;
    int type;
    /**
     * process method processes an event
     */
    public abstract Event process();
    /**
     * compareTo method compares two events based on their time
     * @param event to be compared to
     * @return an integer expressing the result of the comparison
     */
    public int compareTo(Event e){
        return time-e.time;
    }
}
