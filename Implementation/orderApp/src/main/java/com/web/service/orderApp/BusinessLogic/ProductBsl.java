package com.web.service.orderApp.BusinessLogic;
import ch.qos.logback.core.joran.sanity.Pair;
import ch.qos.logback.core.model.INamedModel;
import com.web.service.orderApp.Models.Customer;
import com.web.service.orderApp.Models.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductBsl {
	private List<Product> products = new Vector<>()
	{{
		add(new Product("Food", "Meat", "FM00", "Atyab", 64.5, 30));
		add(new Product("Food", "Chicken", "FC00", "Ikhwan", 65, 20));
		add(new Product("Food", "Kofta", "FK00", "Elmara3i", 90, 44));
		add(new Product("Electronics", "Keyboard", "EK00", "Redragon", 3200, 20));
		add(new Product("Electronics", "Mouse", "EM00", "Dell", 250, 15));
		add(new Product("Electronics", "HeadPhone", "EH00", "Aula", 650, 50));
		add(new Product("Devices", "Iphone", "DI00", "APPLE", 30000, 30));
		add(new Product("Devices", "Washing Machine", "DW00", "Fresh", 6000, 15));
		add(new Product("Devices", "Tablet", "DT00", "Samsung", 12000, 20));
		add(new Product("Cars", "Alantra", "CA00", "Hyundai", 1500000, 7));
		add(new Product("Cars", "Corolla", "CC00", "Toyouta", 1400000, 9));

	}};



	public List<Product> showProducts()
	{
		return  products;
	}


}