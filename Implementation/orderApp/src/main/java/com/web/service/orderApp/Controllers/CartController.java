package com.web.service.orderApp.Controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import com.web.service.orderApp.BusinessLogic.CustomerBsl;
import com.web.service.orderApp.BusinessLogic.ProductBsl;
import com.web.service.orderApp.BusinessLogic.CartBsL;
import com.web.service.orderApp.Models.Cart;

@RestController
public class CartController {
    private final CartBsL cartBsL;

    public CartController() {
        this.cartBsL = new CartBsL();
    }
    @GetMapping(value = "/carts/addToCart")
    public String addToCart(@RequestParam String userName, @RequestParam String productId) {
        ProductBsl productBsl = new ProductBsl();
        CustomerBsl customerBsl = new CustomerBsl();
        if (productBsl.search(productId) == null)
            return "Product not found";
        if (customerBsl.search(userName) == null)
            return "Customer not found";
        cartBsL.add(userName, productBsl.search(productId));
        return "Added to cart successfully";
    }
    @GetMapping(value = "/carts/showCart")
    public Cart printCart(@RequestParam String userName){
        return cartBsL.print(userName);
    }
}