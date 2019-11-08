package pl.filiphagno.DAO;

import pl.filiphagno.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer );
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}