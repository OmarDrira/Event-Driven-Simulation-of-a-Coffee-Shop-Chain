
/**
 * Customer class contains customer information
 *
 * @author Omar Drira
 * @version 04/04/20
 */
public class Customer implements Comparable<Customer>
{
    int arrivalTime;
    Cashier cashier;
    /**
     * Constructor for objects of class Customer
     */
    public Customer(int t)
    {
        arrivalTime=t;
    }
    
    /**
     * compareTo method compares two customers
     * @param customer to be compared to 
     * @return integer expressing the result of the comparison
     */
    public int compareTo(Customer c){
        return arrivalTime-c.arrivalTime;
    }
    
    /**
     * assignCashier method assigns a cashier to the customer
     * @param cashier to be assigned to the customer
     */
    public void assignCashier(Cashier ca){
        cashier=ca;
    }
}
