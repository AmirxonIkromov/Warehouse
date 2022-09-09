package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CustomCurrency {

     Integer getId();

     String getName();

     boolean getActive();
}
