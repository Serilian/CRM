package pl.filiphagno.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.entity.Customer;
import pl.filiphagno.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class CRMController {

    private CustomerService customerService;

    public CRMController() {
    }

    @Autowired
    public CRMController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if(customer != null) {
            return customer;
        } else {
            throw new CustomerRestException("Cant find customer with id: " + customerId);
        }
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        customer.setId(0);
        customerService.addCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer;
    }

    @DeleteMapping(value = "/customers/{customerId}", produces = "application/json")
    public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        if(tempCustomer !=null) {
            customerService.deleteCustomer(customerId);
            Map<String, String> responseMap = new HashMap<>();

            responseMap.put("message","Customer Deleted");

            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        } else {
            throw new CustomerRestException("Cannot delete customer with id: " + customerId);
        }



    }

}
