package pl.filiphagno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.filiphagno.DAO.CustomerDAO;
import pl.filiphagno.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/list")
    public String demo(Model model) {

        List<Customer> customers = customerDAO.getCustomers();

        model.addAttribute("customers",customers);
        return "list-customers";
    }

}
