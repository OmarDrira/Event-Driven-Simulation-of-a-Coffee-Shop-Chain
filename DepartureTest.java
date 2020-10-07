

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DepartureTest.
 *
 * @author  Omar Drira
 * @version 04/20/20
 */
public class DepartureTest
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
     * Default constructor for test class DepartureTest
     */
    public DepartureTest()
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
        assertEquals(9, departur1.compareTo(departur2));
        assertEquals(8, departur1.compareTo(departur3));
        assertEquals(-1, departur2.compareTo(departur3));
        assertEquals(-9, departur2.compareTo(departur1));
        assertEquals(9, departur1.compareTo(arrival4));
        assertEquals(-1, departur2.compareTo(arrival3));
    }

    @Test
    public void testProcess()
    {
        assertNull(departur1.process());
        assertNull(departur2.process());
        assertNull(departur3.process());
    }
}


