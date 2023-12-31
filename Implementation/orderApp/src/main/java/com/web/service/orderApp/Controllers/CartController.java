package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.BusinessLogic.ProductBsl;
import com.web.service.orderApp.BusinessLogic.SingletonHelper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import com.web.service.orderApp.Models.Cart;

@RestController
public class CartController {
    public CartController() {}

    @GetMapping(value = "/carts/addToCart")
    public String addToCart(@RequestParam String userName, @RequestParam String serialNumber) {
        ProductBsl productBsl = SingletonHelper.getProductBsl();
        CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();

        if (productBsl.search(serialNumber) == null)
            return "Product not found";
        if (customerBsl.search(userName) == null)
            return "Customer not found";

        customerBsl.addToCart(productBsl.search(serialNumber), userName);
        return "Added to cart successfully";
    }

    @GetMapping(value = "/carts/showCart")
    public Cart printCart(@RequestParam String userName){
        CustomerBsl customerBsl = SingletonHelper.getCustomerBsl();
        return customerBsl.getCart(userName);
    }
}