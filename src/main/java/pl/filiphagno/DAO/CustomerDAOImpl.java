package pl.filiphagno.DAO;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.filiphagno.entity.Customer;

import java.util.List;

@Slf4j
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query =  session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = query.getResultList();

        log.info("Customers: {}", customers);

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        log.info("Saving customer: {}", customer);

        session.save(customer);
        log.info("Saved customer: {}", customer);
    }
}
