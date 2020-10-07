

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  Omar Drira
 * @version 04/20/20
 */
public class CustomerTest
{
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;

    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
        assertEquals(-1, customer1.compareTo(customer2));
        assertEquals(-2, customer1.compareTo(customer3));
        assertEquals(-1, customer1.compareTo(customer4));
        assertEquals(0, customer2.compareTo(customer4));
        assertEquals(1, customer2.compareTo(customer1));
        assertEquals(-1, customer2.compareTo(customer3));
        assertEquals(2, customer3.compareTo(customer1));
    }
}

