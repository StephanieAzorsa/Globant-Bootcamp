package guide08.activities.challenge.services;

import guide08.activities.group_challenge.services.CustomerService;
import guide08.activities.group_challenge.entities.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    private ArrayList<Customer> customersList;

    @BeforeEach
    void setUp() {
        customersList = new ArrayList<>();
    }

    /**
     * Method under test: {@link CustomerService#createCustomer()}
     */
    @Test
    @Disabled
    void testCreateCustomer() {
        // Set up the expected user input
        String input = "1\nJohn Doe\nTest objective\n30\n1.75\n75.5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method under test
        CustomerService.createCustomer();

        // Get the list of customers and assert the customer has been added correctly
        ArrayList<Customer> customers = CustomerService.getCustomers();
        assertEquals(1, customers.size());

        Customer customer = customers.get(0);
        assertEquals("1", customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("Test objective", customer.getObjective());
        assertEquals(30, customer.getAge());
        assertEquals(1.75, customer.getHeight(), 0.001);
        assertEquals(75.5, customer.getWeight(), 0.001);
    }

    /**
     * Method under test: {@link CustomerService#readCustomers()}
     */
    @Test
    void testReadCustomers() {
        // Arrange: Add some customers to the list
        customersList = CustomerService.getCustomers();
        customersList.add(new Customer("1", "Kamila Jones", 15, 1.60, 60.0, "Objective 1"));
        customersList.add(new Customer("2", "Martin Jones", 25, 1.50, 60.0, "Objective 2"));

        // Act: Call the method under test (this will print the customers to the console)
        CustomerService.readCustomers();
    }

    /**
     * Method under test: {@link CustomerService#updateCustomer(int, String, int, double, double, String)}
     */
    @Test
    void testUpdateCustomer() {
        // Arrange: Add a customer to the list
        customersList = CustomerService.getCustomers();
        customersList.add(new Customer("1", "Kamila Jones", 15, 1.60, 60.0, "Objective 1"));

        // Act: Call the method under test to update the customer
        CustomerService.updateCustomer(1, "New Name", 30, 1.70, 75.0, "New Objective");

        // Assert: Verify that the customer data has been updated
        Customer updatedCustomer = customersList.get(0);
        assertEquals("New Name", updatedCustomer.getName());
        assertEquals("New Objective", updatedCustomer.getObjective());
        assertEquals(30, updatedCustomer.getAge());
        assertEquals(1.70, updatedCustomer.getHeight(), 0.001);
        assertEquals(75.0, updatedCustomer.getWeight(), 0.001);
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomer(int)}
     */
    @Test
    void testDeleteCustomer() {
        // Arrange: Add a customer to the list
        customersList = CustomerService.getCustomers();
        customersList.add(new Customer("1", "Kamila Jones", 15, 1.60, 60.0, "Objective 1"));

        // Act: Call the method under test to delete the customer
        CustomerService.deleteCustomer(1);

        // Assert: Verify that the customer has been removed from the list
        assertTrue(customersList.isEmpty());
    }

    /**
     * Method under test: {@link CustomerService#customerExists(int)}
     */
    @Test
    void testCustomerExists() {
        // Arrange: Add a customer to the list
        customersList = CustomerService.getCustomers();
        customersList.add(new Customer("1", "Kamila Jones", 15, 1.60, 60.0, "Objective 1"));

        // Act & Assert: Verify that the customer exists in the list
        assertTrue(CustomerService.customerExists(1));
        assertFalse(CustomerService.customerExists(2));
    }
}

