package pl.filiphagno.service;

import pl.filiphagno.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
