package com.web.service.orderApp.BusinessLogic;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class SingletonHelper {
    @Getter
    private static CustomerBsl customerBsl = new CustomerBsl();
    @Getter
    private static ProductBsl productBsl = new ProductBsl();
}