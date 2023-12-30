package com.web.service.orderApp.Controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import com.web.service.orderApp.BusinessLogic.ProductBsl;
import com.web.service.orderApp.Models.Product;
import java.util.List;
import java.util.Map;

@RestController

public class ProductController {
	private final ProductBsl productBsl;

	public ProductController() {
		this.productBsl = new ProductBsl();
	}

	@GetMapping(value = "products/showAllProducts")
	public List<Product> showProducts()
	{
		return productBsl.showProducts();
	}
	@GetMapping(value = "products/countProductsInCategory")
	public Map<String, Integer> countProductsInCategory(@RequestParam String category) {
		return productBsl.countProductsInCategory(category);
	}
}