package com.web.service.orderApp.Controllers;

import com.web.service.orderApp.BusinessLogic.CartBsL;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.BusinessLogic.ProductBsl;
import com.web.service.orderApp.Models.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    private CartBsL cartBsL;

    public CartController() {

        this.cartBsL = new CartBsL();

    }

    @GetMapping(value = "/users/addToCart")
    public String addToCart(@RequestParam String userName, @RequestParam String pid) {
        System.out.println(userName + " " + pid);
        ProductBsl productBsl = new ProductBsl();
        CustomerBsl customerBsl = new CustomerBsl();
        if (productBsl.search(pid) == null)
            return "Product not found";
        if (customerBsl.search(userName) == null)
            return "Customer not found";
        cartBsL.add(userName, productBsl.search(pid));
        return "Added to cart successfully";

    }
    @GetMapping(value = "/users/showCart")
    public Cart printCart(@RequestParam String userName){
        return cartBsL.print(userName);
    }

}