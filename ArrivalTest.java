

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArrivalTest.
 *
 * @author  Omar Drira
 * @version 04/20/20
 */
public class ArrivalTest
{
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    private Arrival arrival1;
    private Arrival arrival2;
    private Arrival arrival3;
    private Arrival arrival4;
    private Customer customer5;
    private Customer customer6;
    private Customer customer7;
    private Departure departur1;
    private Departure departur2;
    private Departure departur3;

    
    
    
    
    
    
    
    

    /**
     * Default constructor for test class ArrivalTest
     */
    public ArrivalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        customer1 = new Customer(0);
        customer2 = new Customer(1);
        customer3 = new Customer(2);
        customer4 = new Customer(1);
        arrival1 = new Arrival(customer1, customer1.arrivalTime);
        arrival2 = new Arrival(customer2, customer2.arrivalTime);
        arrival3 = new Arrival(customer3, customer3.arrivalTime);
        arrival4 = new Arrival(customer4, customer4.arrivalTime);
        customer5 = new Customer(10);
        customer6 = new Customer(1);
        customer7 = new Customer(2);
        departur1 = new Departure(customer5, customer5.arrivalTime);
        departur2 = new Departure(customer6, customer6.arrivalTime);
        departur3 = new Departure(customer7, customer7.arrivalTime);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(-1, arrival1.compareTo(arrival2));
        assertEquals(-2, arrival1.compareTo(arrival3));
        assertEquals(-1, arrival2.compareTo(arrival3));
        assertEquals(1, arrival2.compareTo(arrival1));
        assertEquals(0, arrival2.compareTo(arrival4));
        assertEquals(-9, arrival2.compareTo(departur1));
        assertEquals(-9, arrival2.compareTo(departur1));
        assertEquals(-1, arrival2.compareTo(departur3));
        assertEquals(2, arrival3.compareTo(arrival1));
        assertEquals(0, arrival3.compareTo(departur3));
    }

    

    @Test
    public void testProcess()
    {
        Cashier cashier1 = new Cashier();
        customer1.assignCashier(cashier1);
        Departure departur4 = arrival1.process();
        assertNotNull(departur4);
    }
}



