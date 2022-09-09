package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Output;
import com.amirscode.warehouse.entity.OutputProduct;
import com.amirscode.warehouse.entity.Product;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {

     Integer getId();

     long getAmount();

     double getPrice();

    Product getProduct();

    Output getOutput();
}
