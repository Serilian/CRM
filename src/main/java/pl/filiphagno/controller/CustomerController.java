package pl.filiphagno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.entity.Customer;
import pl.filiphagno.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerController() {
    }

    @GetMapping("/list")
    public String demo(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam int customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

}
