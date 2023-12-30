package com.web.service.orderApp.BusinessLogic;
import com.web.service.orderApp.Models.Customer;
import com.web.service.orderApp.Models.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

@Service
public class CustomerBsl {
    private static List<Customer> customers = new Vector<>()
    {{
        add(new Customer("3abdo@gmail.com", "Paswword1", "Abdo", 1500, "011100011", new Vector<>())) ;
        add(new Customer("badr@gmail.com", "Paswword1", "badr", 1500, "011100011", new Vector<>())) ;
        add(new Customer("mohamed@gmail.com", "Paswword1", "MoAmir", 1500, "011100011", new Vector<>())) ;
    }};

    public String register(Customer customer){
        for (Customer customer1 : customers) {
            if (customer1.getUserName().equals(customer.getUserName())) {
                return "this username is already taken";
            }
        }
        customers.add(customer);
        return "added successfully";

    }
    public String login(String email, String password) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)
                    && customer.getPassword().equals(password)) {
                return "login successfully";
            }
        }
        return "invalid email or password";
    }
    public Customer search(String userName){
        for(Customer customer: customers){
            if(customer.getUserName().equals(userName))
                return customer;
        }
        return null;
    }
    public List<Customer> showCustomers()
    {
        return  customers;
    }
}

