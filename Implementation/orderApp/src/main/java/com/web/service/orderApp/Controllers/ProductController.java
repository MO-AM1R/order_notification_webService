package com.web.service.orderApp.Controllers;
import com.web.service.orderApp.BusinessLogic.ProductBsl;
import com.web.service.orderApp.Models.Product;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class ProductController {
	private ProductBsl productBsl;

	public ProductController() {
		this.productBsl = new ProductBsl();
	}

	@GetMapping(value = "/showAllProducts")
	public List<Product> showProducts()
	{
		return productBsl.showProducts();
	}

}