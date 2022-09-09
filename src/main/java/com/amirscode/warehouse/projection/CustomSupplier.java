package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {

     Integer getId();

    String getName();

     boolean getActive();

     String getPhoneNumber();
}
