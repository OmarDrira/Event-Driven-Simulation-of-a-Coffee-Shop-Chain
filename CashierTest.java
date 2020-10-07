

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CashierTest.
 *
 * @author  Omar Drira
 * @version 04/20/20
 */
public class CashierTest
{
    private Cashier cashier1;
    private Cashier cashier2;
    private Cashier cashier3;

    /**
     * Default constructor for test class CashierTest
     */
    public CashierTest()
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
        cashier1 = new Cashier();
        cashier2 = new Cashier();
        cashier3 = new Cashier();
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
    public void testAssign()
    {
        assertNotNull(cashier1.assign(0, 100, 30, 60));
        assertNotNull(cashier2.assign(10, 20, 0, 100));
        assertNotNull(cashier3.assign(12, 90, 19, 21));
    }

    @Test
    public void testNotAvailable()
    {
        cashier1.notAvailable();
        assertEquals(false, cashier1.getAvailable());
        assertEquals(true, cashier2.getAvailable());
        cashier2.notAvailable();
        assertEquals(false, cashier2.getAvailable());
        cashier2.notAvailable();
        assertEquals(false, cashier2.getAvailable());
    }
}


