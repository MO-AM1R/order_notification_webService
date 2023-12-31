package com.web.service.orderApp.BusinessLogic;
import org.springframework.stereotype.Service;
import com.web.service.orderApp.Models.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

@Service
public class CustomerBsl {
    private final List<Customer> customers = new Vector<>()
    {{
        add(new Customer("3abdo@gmail.com", "Paswword1", "Abdo", 1000000, "011100011",
                new Vector<>(), new Cart(new Vector<>(){{
                    add(new Product("Food", "Kofta", "FK00", "Elmara3i", 90, 44));
        }}), new SMS(new Email(new Channel())), "Arabic")) ;
        add(new Customer("badr@gmail.com", "Paswword1", "badr", 1000000, "011100011",
                new Vector<>(), new Cart(new ArrayList<>()), new SMS(new Channel()), "English")) ;
        add(new Customer("mohamed@gmail.com", "Paswword1", "MoAmir", 1000000, "011100011",
                new Vector<>(), new Cart(new ArrayList<>()), new Email(new Channel()), "Arabic")) ;
        add(new Customer("ahmed@gmail.com", "Paswword1", "Yasser", 1000000, "011100011",
                new Vector<>(), new Cart(new ArrayList<>()), new Email(new SMS(new Channel())), "Arabic")) ;
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
    public String showCustomers()
    {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Customer customer : customers) {
            stringBuilder.append(customer.toString()).append('\n');
        }
        return stringBuilder.append(']').toString();
    }
    public void decreaseBalance(String userName, double amount) {
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)){
                customer.setBalance(customer.getBalance() - amount);
            }
        }
    }
    public void addToCart(Product product, String userName){
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)){
                List<Product> products = customer.getCart().getProducts() ;
                products.add(product);
                customer.getCart().setProducts(products);
            }
        }
    }
    public Cart getCart(String userName) {
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)){
                return customer.getCart();
            }
        }
        return null;
    }
    public void clearCart(String userName){
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)){
                customer.setCart(new Cart(new ArrayList<>()));
            }
        }
    }
}