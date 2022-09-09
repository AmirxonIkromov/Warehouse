package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Input;
import com.amirscode.warehouse.entity.InputProduct;
import com.amirscode.warehouse.entity.Product;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Projection(types = InputProduct.class)
public interface CustomInputProduct {

     Integer getId();

     long getAmount();

     float getPrice();

    Date getExpireDate();

    Product getProduct();

    Input getInput();
}
